package entities

import kotlinx.serialization.Serializable

@Serializable
data class EquipmentStat(
    val attackSpeed: String? = null,
    override val attack: String? = null,
    override val defence: String? = null,
    override val cooldownReduction: String? = null,
) : ICommonStat
