package element.trigger

import element.ElementType
import element.IElement
import element.IElementData
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
