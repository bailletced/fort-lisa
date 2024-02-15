package entity.item.gift

import kotlinx.serialization.Serializable

@Serializable
data class GiftCapacityEntity(
    val will: Int = 0,
    val intellect: Int = 0,
    val memory: Int = 0,
)
