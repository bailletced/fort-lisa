package stat.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class StatPlayer(
    val attackSpeed: Double? = null,
    val cooldownReduction: Double? = null,
    override val attack: Double? = null,
    override val defence: Double? = null,
) : IStatEntity, StatCommonEntity()
