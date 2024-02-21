package adapters.deserializers

import adapters.GenericDeserializer
import entities.EquipmentEntity

class EquipmentEntityDeserializer : GenericDeserializer<EquipmentEntity>(EquipmentEntity.serializer())
