package entities.stat

import kotlinx.serialization.Serializable

@Serializable
abstract class StatCommonEntity {
    abstract val attack: Double?
    abstract val defence: Double?

    fun getValue(propertyName: String): Double? {
        return when (propertyName) {
            "attack" -> attack
            "defense" -> defence
            else -> throw IllegalArgumentException("Property not found")
        }
    }
}

interface IStatEntity
