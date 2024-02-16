package element.trigger

import element.ElementType
import element.IElement
import element.IElementData
import kotlinx.serialization.Serializable

@Serializable
data class TriggerWearingEntity(
    override val type: ElementType = ElementType.Trigger,
    override val id: TriggerId = TriggerId.Wearing,
    override val data: IElementData? = null,
    override val children: List<IElement> = listOf(),
) : IElement
