package entities.element.trigger

import entities.element.IElementId
import kotlinx.serialization.Serializable

@Serializable
enum class TriggerId : IElementId {
    Click,
    Wearing,
}
