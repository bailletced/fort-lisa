package element.entities.mechanic

import element.entities.ElementType
import element.entities.IElement
import element.entities.IElementData
import entities.SkillId
import kotlinx.serialization.Serializable

@Serializable
data class MechanicSkillEntity(
    override val type: ElementType = ElementType.Mechanic,
    override val id: MechanicId = MechanicId.Skill,
    override val data: MechanicSkillEntityData,
    override val children: List<IElement> = listOf(),
) : IElement

@Serializable
data class MechanicSkillEntityData(
    val action: MechanicSkillEntityAction,
    val skillId: SkillId,
) : IElementData

enum class MechanicSkillEntityAction {
    Cast,
    Give,
}
