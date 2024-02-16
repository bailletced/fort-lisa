package services

import deserializer.services.DeserializerService
import entities.EquipmentEntity

class EntityDeserializerService() {
    fun parseEquipment(json: String): EquipmentEntity {
        return DeserializerService().decodeFromString(json)
    }
}
