package element.domain.entities

import kotlinx.serialization.Serializable

@Serializable
enum class ElementType {
    Trigger,
    Mechanic,
    Condition,
    Target,
}
