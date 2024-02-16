package entity.item

import element.IElement
import entity.StatEntity
import entity.item.gift.GiftCapacityEntity
import entity.item.gift.GiftWill

interface IItemType

interface IItemCategory

interface IItemId

interface IItem {
    val type: IItemType
    val category: IItemCategory
    val id: IItemId
    val tier: Int
    val stat: StatEntity
    val material: Map<GiftWill, String>
    val giftCapacity: GiftCapacityEntity?
    val elements: List<IElement>
}
