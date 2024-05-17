package item.domain.gateways.repositories

import item.domain.entities.IItemEntity
import item.domain.entities.IItemEntityCategory
import item.domain.entities.IItemEntityId
import item.domain.entities.ItemType

interface IItemEntityRepository<T : IItemEntity> {
    fun find(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T
}
