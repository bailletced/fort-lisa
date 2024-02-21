package entity.item

import entities.GiftCapacityEntity
import entities.GiftWill
import entities.ICommonStat
import entities.IElement

interface IItemType

interface IItemCategory

interface IItemId

interface IItem {
    val type: IItemType
    val category: IItemCategory
    val id: IItemId
    val tier: Int
    val stat: ICommonStat
    val material: Map<GiftWill, String>
    val giftCapacity: GiftCapacityEntity?
    val elements: List<IElement>
}
