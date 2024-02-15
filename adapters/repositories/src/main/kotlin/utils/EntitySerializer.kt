package utils

import entity.item.equipment.EquipmentEntity
import kotlinx.serialization.json.Json

class EntitySerializer() {
    val format =
        Json {
            isLenient = true
            ignoreUnknownKeys = false
        }

    fun parseEquipment(json: String): EquipmentEntity {
        return decodeFromString(json)
    }

    private inline fun <reified T> decodeFromString(json: String): T {
        try {
            return format.decodeFromString(json) as T
        } catch (e: Exception) {
            throw Exception("Failed to deserialize. ${e.message}", e)
        }
    }
}
