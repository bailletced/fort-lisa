package repository.item

import entity.item.Item
import entity.item.ItemCategory
import entity.item.ItemId

interface EquipmentRepository {
    fun find(
        category: ItemCategory,
        id: ItemId,
    ): Item?
}
