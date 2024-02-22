package entities.item.equipment

import entities.element.IElement
import entities.item.EItemType
import entities.item.IDynamicItemEntity
import entities.item.IItemEntity
import entities.item.gift.GiftCapacityEntity
import entities.item.gift.GiftWill
import kotlinx.serialization.Serializable

@Serializable
data class EquipmentEntity(
    override val type: EItemType = EItemType.Equipment,
    override val category: EquipmentCategory,
    override val id: EquipmentId,
    override val tier: Int = 1,
    override val stat: EquipmentStat,
    override val material: Map<GiftWill, String>,
    override val giftCapacity: GiftCapacityEntity?,
    override val elements: List<IElement>,
) : IItemEntity, IDynamicItemEntity
