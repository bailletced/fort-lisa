package gateways.repository.item

import entities.item.equipment.EquipmentCategory
import entities.item.equipment.EquipmentEntity
import entities.item.equipment.EquipmentId
import gateways.service.file.IFileReaderService

abstract class EquipmentRepositoryFile(
    val fileReaderService: IFileReaderService,
) {
    abstract fun find(
        category: EquipmentCategory,
        id: EquipmentId,
    ): EquipmentEntity?
}
