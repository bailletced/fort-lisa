package entities.element

import kotlinx.serialization.Serializable

@Serializable
enum class ElementType {
    Trigger,
    Mechanic,
    Condition,
    Target,
}
