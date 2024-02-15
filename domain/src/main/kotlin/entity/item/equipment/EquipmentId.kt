package entity.item.equipment

import entity.item.ItemId

enum class EquipmentId(val category: EquipmentCategory) : ItemId {
    LaurelCrown(EquipmentCategory.Helmet),
}
