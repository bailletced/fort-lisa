package entities.item.skill

import entities.element.IElement
import entities.item.IItemEntity
import entities.item.ItemType
import entities.item.gift.GiftCapacity
import entities.item.gift.GiftWill
import kotlinx.serialization.Serializable

@Serializable
data class Skill(
    override val type: ItemType = ItemType.Skill,
    override val category: GiftWill,
    override val id: SkillId,
    override val material: Map<GiftWill, String>,
    override val elements: List<IElement>? = listOf(),
    override val tier: Int? = null,
    override val giftCapacity: GiftCapacity? = GiftCapacity(0, 0, 0),
    val formula: Map<String, String>? = null,
) : IItemEntity
