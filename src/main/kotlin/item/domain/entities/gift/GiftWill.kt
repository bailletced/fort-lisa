package item.domain.entities.gift

import item.domain.entities.IItemEntityCategory
import kotlinx.serialization.Serializable

@Serializable
enum class GiftWill : IItemEntityCategory {
    Base,
    BurningHeart,
}
