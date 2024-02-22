package repository.item

import entities.item.equipment.EquipmentCategory
import entities.item.equipment.EquipmentEntity
import entities.item.equipment.EquipmentId
import gateways.repository.item.EquipmentRepositoryFile
import gateways.service.deserializer.DeserializerService
import gateways.service.file.IFileReaderService

class EquipmentRepositoryFileImpl(
    fileReaderService: IFileReaderService,
    val deserializerService: DeserializerService<EquipmentEntity>,
) : EquipmentRepositoryFile(fileReaderService) {
    override fun find(
        category: EquipmentCategory,
        id: EquipmentId,
    ): EquipmentEntity {
        val json = fileReaderService.read("/item/equipment/${category.toString().lowercase()}/$id.json")

        return deserializerService.deserialize(json)
    }
}
