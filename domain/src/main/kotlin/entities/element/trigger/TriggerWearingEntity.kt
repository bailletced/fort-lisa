package entities.element.trigger

import entities.element.ElementType
import entities.element.IElement
import entities.element.IElementData
import kotlinx.serialization.Serializable

@Serializable
data class TriggerWearingEntity(
    override val type: ElementType = ElementType.Trigger,
    override val id: TriggerId = TriggerId.Wearing,
    override val data: IElementData? = null,
    override val children: List<IElement> = listOf(),
) : IElement
