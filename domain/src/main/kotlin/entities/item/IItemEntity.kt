package entities.item

import entities.element.IElement
import entities.item.gift.GiftCapacity
import entities.item.gift.GiftWill

interface IItemEntityCategory

interface IItemEntityId

interface IItemEntity {
    val type: ItemType
    val category: IItemEntityCategory
    val id: IItemEntityId
    val material: Map<GiftWill, String>

    val tier: Int?
    val giftCapacity: GiftCapacity?
    val elements: List<IElement>?
}
