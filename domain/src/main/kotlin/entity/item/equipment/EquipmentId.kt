package entity.item.equipment

import entity.item.IItemId

enum class EquipmentId(val category: EquipmentCategory) : IItemId {
    LaurelCrown(EquipmentCategory.Helmet),
}
