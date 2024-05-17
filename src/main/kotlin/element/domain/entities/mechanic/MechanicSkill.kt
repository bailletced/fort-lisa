
package element.domain.entities.mechanic

import element.domain.entities.ElementType
import element.domain.entities.IElement
import element.domain.entities.IElementData
import item.domain.entities.skill.SkillId
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
