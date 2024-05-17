package element.domain.entities.mechanic

import element.domain.entities.IElementId
import kotlinx.serialization.Serializable

@Serializable
enum class MechanicId : IElementId {
    Skill,
    Immunity,
}
