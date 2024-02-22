package entities.item

import entities.element.IElement
import entities.item.gift.GiftCapacityEntity
import entities.item.gift.GiftWill
import entities.stat.IStatEntity

interface IItemEntityCategory

interface IItemEntityId

interface IItemEntity {
    val type: EItemType
    val category: IItemEntityCategory
    val id: IItemEntityId
    val stat: IStatEntity
    val material: Map<GiftWill, String>
}

interface IDynamicItemEntity {
    val tier: Int
    val giftCapacity: GiftCapacityEntity?
    val elements: List<IElement>
}