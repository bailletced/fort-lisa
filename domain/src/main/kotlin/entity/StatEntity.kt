package entity

import kotlinx.serialization.Serializable

@Serializable
data class StatEntity(
    val attack: String? = null,
    val effectAttack: String? = null,
    val effectDuration: String? = null,
    val defence: String? = null,
    val cooldown: String? = null,
    val range: String? = null,
    val projectileSpeed: String? = null,
    val projectileAmount: String? = null,
    val knockback: String? = null,
    val propulsion: String? = null,
    val usageAdditional: String? = null,
)
