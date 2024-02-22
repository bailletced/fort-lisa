package entities.item.equipment

import entities.item.EItemType
import entities.item.IItemEntityCategory

enum class EquipmentCategory(val type: EItemType) : IItemEntityCategory {
    Helmet(EItemType.Equipment),
    ChestPlate(EItemType.Equipment),
    Leggings(EItemType.Equipment),
    Boots(EItemType.Equipment),
}
