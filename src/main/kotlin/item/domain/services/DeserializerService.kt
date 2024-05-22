package item.domain.services

import item.domain.entities.IItem
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class DeserializerService<T : IItem>(
    val serializer: KSerializer<T>,
) {
    private val format =
        Json {
            isLenient = true
            ignoreUnknownKeys = false
        }

    fun deserialize(json: String): T {
        try {
            return format.decodeFromString(serializer, json)
        } catch (e: Exception) {
            throw Exception("Failed to deserialize. ${e.message}", e)
        }
    }
}
