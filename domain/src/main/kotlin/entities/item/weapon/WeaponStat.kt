package entities.item.weapon

import entities.stat.IStatCommonEntity
import entities.stat.IStatEntity
import kotlinx.serialization.Serializable

@Serializable
data class WeaponStat(
    val attackSpeed: String? = null,
    override val attack: String? = null,
    override val defence: String? = null,
    val cooldownReduction: String? = null,
) : IStatEntity, IStatCommonEntity
