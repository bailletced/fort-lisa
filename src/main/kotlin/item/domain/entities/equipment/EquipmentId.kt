package item.domain.entities.equipment

import item.domain.entities.IItemEntityId

enum class EquipmentId(val category: EquipmentCategory) : IItemEntityId {
    LaurelCrown(EquipmentCategory.Helmet),
}
