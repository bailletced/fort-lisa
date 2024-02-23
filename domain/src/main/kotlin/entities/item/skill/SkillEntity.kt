package entities.item.skill

import entities.element.IElement
import entities.item.IItemEntity
import entities.item.ItemType
import entities.item.gift.GiftCapacityEntity
import entities.item.gift.GiftWill
import kotlinx.serialization.Serializable

@Serializable
data class SkillEntity(
    override val type: ItemType = ItemType.Skill,
    override val category: GiftWill,
    override val id: SkillId,
    override val stat: SkillStat,
    override val material: Map<GiftWill, String>,
    override val elements: List<IElement>? = listOf(),
    override val tier: Int? = null,
    override val giftCapacity: GiftCapacityEntity? = GiftCapacityEntity(0, 0, 0),
) : IItemEntity
