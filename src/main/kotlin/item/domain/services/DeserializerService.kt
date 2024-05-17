package item.domain.services

import item.domain.entities.IItemEntity
import item.domain.entities.equipment.Equipment
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json


class DeserializerService(
    val serializer: KSerializer<Equipment>
) {
    private val format =
        Json {
            isLenient = true
            ignoreUnknownKeys = false
        }

     fun deserialize(json: String): IItemEntity {
        try {
            return format.decodeFromString(serializer, json)
        } catch (e: Exception) {
            throw Exception("Failed to deserialize. ${e.message}", e)
        }
    }
}
