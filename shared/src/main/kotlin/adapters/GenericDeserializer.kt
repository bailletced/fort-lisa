package adapters

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.Json

open class GenericDeserializer<T>(private val serializer: DeserializationStrategy<T>) {
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
