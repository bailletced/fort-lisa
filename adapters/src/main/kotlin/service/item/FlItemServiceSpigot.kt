package service.item

import entities.item.IItemEntity
import entities.item.IItemEntityCategory
import entities.item.IItemEntityId
import entities.item.ItemType
import entities.item.fl.IGameItemEntity
import entities.player.PlayerStat
import gateways.repository.item.IItemEntityRepository
import gateways.repository.item.fl.IFlItemRepository
import gateways.service.i18n.I18nService
import gateways.service.item.IFlItemService
import processors.utils.StringUtils
import java.util.Locale

fun String.decapitalizeFirstChar(): String {
    return this[0].lowercase() + substring(1)
}

class FlItemServiceSpigot<T : IItemEntity>(
    val i18nService: I18nService,
    val itemEntityRepo: IItemEntityRepository<T>,
    val flItemRepo: IFlItemRepository,
) : IFlItemService<T> {
    override fun generate(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T {
        val itemEntity = generateItemEntity(type, category, id)
        return itemEntity
    }

    override fun generateItemEntity(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T {
        return itemEntityRepo.find(type, category, id)
    }

    override fun generateGameItemEntity(entity: IItemEntity): IGameItemEntity {
        TODO("Not yet implemented")
    }

    override fun generateLore(
        itemEntity: IItemEntity,
        playerStat: PlayerStat,
    ): List<String> {
        fun transformKey(
            itemEntity: IItemEntity,
            key: String,
        ): String {
            return "item.${itemEntity.type.toString().decapitalizeFirstChar()}" +
                ".${itemEntity.category.toString().decapitalizeFirstChar()}" +
                ".${itemEntity.id.toString().decapitalizeFirstChar()}.$key"
        }

        val i18nString =
            StringUtils.i18nKeyFromStrings(
                listOf(
                    itemEntity.type.toString(),
                    itemEntity.category.toString(),
                    itemEntity.id.toString(),
                ),
                "item.",
            )

        return listOf(
            i18nService.getMessage(Locale.FRANCE, "$i18nString.title"),
            i18nService.getMessage(Locale.FRANCE, "$i18nString.lore"),
        )
    }
}
