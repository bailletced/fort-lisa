package gateways.repository.item

import entities.item.IItemEntity
import entities.item.IItemEntityCategory
import entities.item.IItemEntityId
import entities.item.ItemType

interface IItemEntityRepository<T : IItemEntity> {
    fun find(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T
}
