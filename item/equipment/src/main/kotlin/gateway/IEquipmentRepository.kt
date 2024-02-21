package gateway

import entities.EquipmentCategory
import entities.EquipmentEntity
import entities.EquipmentId

interface IEquipmentRepository {
    fun find(
        category: EquipmentCategory,
        id: EquipmentId,
    ): EquipmentEntity?
}
