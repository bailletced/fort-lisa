package entities.item.skill

import entities.item.EItemType
import entities.item.IItemEntity
import entities.item.gift.GiftWill
import kotlinx.serialization.Serializable

@Serializable
data class SkillEntity(
    override val type: EItemType = EItemType.Skill,
    override val category: GiftWill,
    override val id: SkillId,
    override val stat: SkillStat,
    override val material: Map<GiftWill, String>,
) : IItemEntity
