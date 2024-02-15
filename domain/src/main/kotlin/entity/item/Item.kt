package entity.item

import entity.StatEntity
import entity.item.gift.GiftCapacityEntity
import entity.item.gift.GiftWill

interface ItemType

interface ItemCategory

interface ItemId

interface Item {
    val type: ItemType
    val category: ItemCategory
    val id: ItemId
    val tier: Int
    val stat: StatEntity
    val material: Map<GiftWill, String>
    val giftCapacity: GiftCapacityEntity?
}
