package repository.item

import entity.item.IItem
import entity.item.IItemCategory
import entity.item.IItemId

interface EquipmentRepository {
    fun find(
        category: IItemCategory,
        id: IItemId,
    ): IItem?
}
