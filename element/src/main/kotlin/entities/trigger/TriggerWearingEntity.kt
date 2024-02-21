package entities.trigger

import entities.ElementType
import entities.IElement
import entities.IElementData
import kotlinx.serialization.Serializable

@Serializable
data class TriggerWearingEntity(
    override val type: ElementType = ElementType.Trigger,
    override val id: TriggerId = TriggerId.Wearing,
    override val data: IElementData? = null,
    override val children: List<IElement> = listOf(),
) : IElement
