package entity.item.entities

import entity.item.IItem
import entity.item.IItemCategory
import entity.item.IItemId

interface ItemDeserializerEntity {
    fun find(
        category: IItemCategory,
        id: IItemId,
    ): IItem
}
