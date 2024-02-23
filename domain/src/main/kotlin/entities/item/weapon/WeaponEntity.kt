package entities.item.weapon

import entities.element.IElement
import entities.item.IItemEntity
import entities.item.ItemType
import entities.item.gift.GiftCapacityEntity
import entities.item.gift.GiftWill
import kotlinx.serialization.Serializable

@Serializable
data class WeaponEntity(
    override val type: ItemType = ItemType.Weapon,
    override val category: WeaponCategory,
    override val id: WeaponId,
    override val tier: Int = 1,
    override val stat: WeaponStat,
    override val material: Map<GiftWill, String>,
    override val giftCapacity: GiftCapacityEntity?,
    override val elements: List<IElement>,
) : IItemEntity
