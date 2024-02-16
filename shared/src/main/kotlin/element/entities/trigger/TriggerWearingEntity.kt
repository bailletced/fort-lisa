package element.entities.trigger

import element.entities.ElementType
import element.entities.IElement
import element.entities.IElementData
import element.entities.IElementId
import kotlinx.serialization.Serializable

@Serializable
data class TriggerWearingEntity(
    override val type: ElementType = ElementType.Trigger,
    override val id: IElementId = TriggerId.Wearing,
    override val data: IElementData? = null,
    override val children: List<IElement> = listOf(),
) : IElement
