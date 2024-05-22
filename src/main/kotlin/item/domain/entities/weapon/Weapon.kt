package item.domain.entities.weapon

import element.domain.entities.IElement
import item.domain.entities.IItem
import item.domain.entities.ItemType
import item.domain.entities.gift.GiftCapacity
import item.domain.entities.gift.GiftWill
import kotlinx.serialization.Serializable

@Serializable
data class Weapon(
    override val type: ItemType = ItemType.Weapon,
    override val category: WeaponCategory,
    override val id: WeaponId,
    override val tier: Int = 1,
    override val material: Map<GiftWill, String>,
    override val giftCapacity: GiftCapacity?,
    override val elements: List<IElement>,
    override val mapFormula: Map<String, String>?,
) : IItem
