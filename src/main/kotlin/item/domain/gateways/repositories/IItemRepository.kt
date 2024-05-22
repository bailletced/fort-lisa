package item.domain.gateways.repositories

import item.domain.entities.IItem
import item.domain.entities.IItemEntityCategory
import item.domain.entities.IItemEntityId
import item.domain.entities.ItemType

interface IItemRepository<T : IItem> {
    fun find(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T
}
