package item.domain.entities.equipment

import element.domain.entities.IElement
import item.domain.entities.IItemEntity
import item.domain.entities.ItemType
import item.domain.entities.gift.GiftCapacity
import item.domain.entities.gift.GiftWill
import kotlinx.serialization.Serializable
import stat.domain.entities.StatEquipment

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
    override val mapFormula: Map<String, String>?,
) : IItemEntity
