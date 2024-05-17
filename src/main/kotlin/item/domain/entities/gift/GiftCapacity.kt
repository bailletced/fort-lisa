package item.domain.entities.gift

import kotlinx.serialization.Serializable

@Serializable
data class GiftCapacity(
    val will: Int = 0,
    val intellect: Int = 0,
    val memory: Int = 0,
)
