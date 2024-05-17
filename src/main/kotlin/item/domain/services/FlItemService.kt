package item.domain.services

import i18n.domain.services.I18nService
import item.domain.entities.IItemEntity
import item.domain.entities.IItemEntityCategory
import item.domain.entities.IItemEntityId
import item.domain.entities.ItemType
import item.infra.GameItemEntity
import item.domain.gateways.repositories.IFlItemRepository
import item.domain.gateways.repositories.IItemEntityRepository
import stat.domain.entities.StatPlayer
import utils.StringUtils
import java.util.Locale

fun String.decapitalizeFirstChar(): String {
    return this[0].lowercase() + substring(1)
}

class FlItemService<T : IItemEntity>(
    val i18nService: I18nService,
    val itemEntityRepo: IItemEntityRepository<T>,
    val flItemRepo: IFlItemRepository,
) {
     fun generate(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T {
        val itemEntity = generateItemEntity(type, category, id)
        return itemEntity
    }

    fun generateItemEntity(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T {
        return itemEntityRepo.find(type, category, id)
    }

    fun generateGameItemEntity(entity: IItemEntity): GameItemEntity {
        TODO("Not yet implemented")
    }

    fun generateLore(
        itemEntity: IItemEntity,
        playerStat: StatPlayer,
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
