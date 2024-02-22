package entities.item.equipment

import entities.item.IItemEntityId

enum class EquipmentId(val category: EquipmentCategory) : IItemEntityId {
    LaurelCrown(EquipmentCategory.Helmet),
}
