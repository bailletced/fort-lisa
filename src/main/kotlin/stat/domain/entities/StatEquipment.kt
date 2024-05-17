package stat.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class StatEquipment(
    override val attack: Double? = null,
    override val defence: Double? = null,
    val cooldownReduction: Double? = null,
) : IStatEntity, StatCommonEntity()
