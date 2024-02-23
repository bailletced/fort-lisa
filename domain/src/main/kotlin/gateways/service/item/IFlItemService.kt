package gateways.service.item

import entities.item.IItemEntity
import entities.item.IItemEntityCategory
import entities.item.IItemEntityId
import entities.item.ItemType
import entities.item.fl.IGameItemEntity
import entities.player.PlayerStat

interface IFlItemService<T : IItemEntity> {
    fun generate(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T

    fun generateItemEntity(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T

    fun generateGameItemEntity(entity: IItemEntity): IGameItemEntity

    fun generateLore(
        itemEntity: IItemEntity,
        playerStat: PlayerStat,
    ): List<String>
}
