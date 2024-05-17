package item.domain.entities.equipment

import item.domain.entities.IItemEntityCategory
import item.domain.entities.ItemType

enum class EquipmentCategory(val type: ItemType) : IItemEntityCategory {
    Helmet(ItemType.Equipment),
    ChestPlate(ItemType.Equipment),
    Leggings(ItemType.Equipment),
    Boots(ItemType.Equipment),
}
