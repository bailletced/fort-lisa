package entities.item.equipment

import entities.item.IItemEntityCategory
import entities.item.ItemType

enum class EquipmentCategory(val type: ItemType) : IItemEntityCategory {
    Helmet(ItemType.Equipment),
    ChestPlate(ItemType.Equipment),
    Leggings(ItemType.Equipment),
    Boots(ItemType.Equipment),
}
