package entities.mechanic

import entities.IElementId
import kotlinx.serialization.Serializable

@Serializable
enum class MechanicId : IElementId {
    Skill,
    Immunity,
}
