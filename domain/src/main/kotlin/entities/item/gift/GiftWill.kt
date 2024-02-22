package entities.item.gift

import entities.item.IItemEntityCategory
import kotlinx.serialization.Serializable

@Serializable
enum class GiftWill : IItemEntityCategory {
    Base,
    BurningHeart,
}
