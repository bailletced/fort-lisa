package item.domain.gateways.repositories

import item.domain.entities.IItem
import item.domain.entities.IItemEntityCategory
import item.domain.entities.IItemEntityId

interface IItemRepository<T : IItem> {
    fun find(
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T
}
