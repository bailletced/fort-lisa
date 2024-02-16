package entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GiftWill {
    @SerialName("base")
    BASE,

    @SerialName("burningHeart")
    BURNING_HEART,
}
