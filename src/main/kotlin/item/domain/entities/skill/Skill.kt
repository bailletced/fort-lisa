package item.domain.entities.skill

import element.domain.entities.IElement
import item.domain.entities.IItemEntity
import item.domain.entities.ItemType
import item.domain.entities.gift.GiftCapacity
import item.domain.entities.gift.GiftWill
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
    override val mapFormula: Map<String, String> = mapOf(),
) : IItemEntity
