package service.deserializer

import gateways.service.deserializer.DeserializerService
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.Json

class DeserializerServiceImpl<T>(serializer: DeserializationStrategy<T>) : DeserializerService<T>(serializer) {
    private val format =
        Json {
            isLenient = true
            ignoreUnknownKeys = false
        }

    override fun deserialize(json: String): T {
        try {
            return format.decodeFromString(serializer, json)
        } catch (e: Exception) {
            throw Exception("Failed to deserialize. ${e.message}", e)
        }
    }
}
