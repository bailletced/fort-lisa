package adapters.repositorites

import adapters.deserializers.EquipmentEntityDeserializer
import entities.EquipmentCategory
import entities.EquipmentEntity
import entities.EquipmentId
import gateway.IEquipmentRepository

class EquipmentRepositoryFile : IEquipmentRepository {
    override fun find(
        category: EquipmentCategory,
        id: EquipmentId,
    ): EquipmentEntity {
        val json =
            this::class.java.getResource("/equipment/${category.toString().lowercase()}/$id.json")?.readText()
        if (json.isNullOrEmpty()) {
            throw Exception("no equipment found. $category $id")
        }

        return EquipmentEntityDeserializer().deserialize(json)
    }
}
