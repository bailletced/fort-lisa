package element.domain.entities.trigger

import element.domain.entities.IElementId
import kotlinx.serialization.Serializable

@Serializable
enum class TriggerId : IElementId {
    Click,
    Wearing,
}
