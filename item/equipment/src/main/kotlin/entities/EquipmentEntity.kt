package entities

import entity.item.EItemType
import entity.item.IItem
import entity.item.IItemType
import kotlinx.serialization.Serializable

@Serializable
data class EquipmentEntity(
    override val type: IItemType = EItemType.Equipment,
    override val category: EquipmentCategory,
    override val id: EquipmentId,
    override val tier: Int = 1,
    override val stat: EquipmentStat,
    override val material: Map<GiftWill, String>,
    override val giftCapacity: GiftCapacityEntity?,
    override val elements: List<IElement>,
) : IItem
