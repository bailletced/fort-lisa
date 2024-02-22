package entities.item.skill

import entities.stat.IStatCommonEntity
import entities.stat.IStatEntity
import kotlinx.serialization.Serializable

@Serializable
data class SkillStat(
    override val attack: String? = null,
    override val defence: String? = null,
) : IStatEntity, IStatCommonEntity
