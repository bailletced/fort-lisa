
package entities.element.mechanic

import entities.element.ElementType
import entities.element.IElement
import entities.element.IElementData
import entities.item.skill.SkillId
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
