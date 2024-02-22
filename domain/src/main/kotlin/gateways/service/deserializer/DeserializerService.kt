package gateways.service.deserializer

import kotlinx.serialization.DeserializationStrategy

abstract class DeserializerService<T>(val serializer: DeserializationStrategy<T>) {
    abstract fun deserialize(json: String): T
}
