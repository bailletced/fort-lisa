package entities.element.mechanic

import entities.element.IElementId
import kotlinx.serialization.Serializable

@Serializable
enum class MechanicId : IElementId {
    Skill,
    Immunity,
}
