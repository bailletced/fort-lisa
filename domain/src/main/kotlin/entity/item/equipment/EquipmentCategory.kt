package entity.item.equipment

import entity.item.EItemType
import entity.item.ItemCategory

enum class EquipmentCategory(val type: EItemType) : ItemCategory {
    Helmet(EItemType.Equipment),
    ChestPlate(EItemType.Equipment),
    Leggings(EItemType.Equipment),
    Boots(EItemType.Equipment),
}
