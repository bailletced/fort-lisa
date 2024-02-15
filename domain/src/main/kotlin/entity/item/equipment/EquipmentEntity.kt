package entity.item.equipment

import entity.StatEntity
import entity.item.EItemType
import entity.item.Item
import entity.item.ItemType
import entity.item.gift.GiftCapacityEntity
import entity.item.gift.GiftWill
import kotlinx.serialization.Serializable

@Serializable
data class EquipmentEntity(
    override val type: ItemType = EItemType.Equipment,
    override val category: EquipmentCategory,
    override val id: EquipmentId,
    override val tier: Int = 1,
    override val stat: StatEntity,
    override val material: Map<GiftWill, String>,
    override val giftCapacity: GiftCapacityEntity?,
) : Item
