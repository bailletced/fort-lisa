package entity.item

import element.entities.IElement
import entities.GiftCapacityEntity
import entities.GiftWill
import stat.entities.StatEntity

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
