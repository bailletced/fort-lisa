package entities.trigger

import entities.IElementId
import kotlinx.serialization.Serializable

@Serializable
enum class TriggerId : IElementId {
    Click,
    Wearing,
}
