package entities.item.equipment

import entities.element.IElement
import entities.item.IItemEntity
import entities.item.ItemType
import entities.item.gift.GiftCapacity
import entities.item.gift.GiftWill
import entities.stat.StatEquipment
import kotlinx.serialization.Serializable

@Serializable
data class Equipment(
    override val type: ItemType = ItemType.Equipment,
    override val category: EquipmentCategory,
    override val id: EquipmentId,
    override val tier: Int = 1,
    override val material: Map<GiftWill, String>,
    override val giftCapacity: GiftCapacity?,
    override val elements: List<IElement>,
    val stat: StatEquipment,
) : IItemEntity
