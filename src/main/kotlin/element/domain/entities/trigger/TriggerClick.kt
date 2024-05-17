package element.domain.entities.trigger

import element.domain.entities.ElementType
import element.domain.entities.IElement
import element.domain.entities.IElementData
import kotlinx.serialization.Serializable


@Serializable
data class TriggerClickEntity(
    override val type: ElementType = ElementType.Trigger,
    override val id: TriggerId = TriggerId.Click,
    override val data: TriggerClickEntityData,
    override val children: List<IElement> = listOf(),
) : IElement

@Serializable
data class TriggerClickEntityData(
    val clickId: TriggerClick,
) : IElementData

@Serializable
enum class TriggerClick {
    RightClick,
    LeftClick,
}
