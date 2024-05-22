package item.domain.entities

import element.domain.entities.IElement
import item.domain.entities.gift.GiftCapacity
import item.domain.entities.gift.GiftWill

interface IItemEntityCategory

interface IItemEntityId

interface IItem {
    val type: ItemType
    val category: IItemEntityCategory
    val id: IItemEntityId
    val material: Map<GiftWill, String>

    val tier: Int?
    val giftCapacity: GiftCapacity?
    val elements: List<IElement>?
    val mapFormula: Map<String, String>?
}
