package entity.item.equipment

import entity.item.EItemType
import entity.item.IItemCategory

enum class EquipmentCategory(val type: EItemType) : IItemCategory {
    Helmet(EItemType.Equipment),
    ChestPlate(EItemType.Equipment),
    Leggings(EItemType.Equipment),
    Boots(EItemType.Equipment),
}
