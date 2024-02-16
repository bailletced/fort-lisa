package deserializer.services

import kotlinx.serialization.json.Json

class DeserializerService {
    val format =
        Json {
            isLenient = true
            ignoreUnknownKeys = false
        }

    inline fun <reified T> decodeFromString(json: String): T {
        try {
            return format.decodeFromString(json) as T
        } catch (e: Exception) {
            throw Exception("Failed to deserialize. ${e.message}", e)
        }
    }
}
