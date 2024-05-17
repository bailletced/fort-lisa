package element.domain.entities.trigger

import element.domain.entities.ElementType
import element.domain.entities.IElement
import element.domain.entities.IElementData
import kotlinx.serialization.Serializable


@Serializable
data class TriggerWearing(
    override val type: ElementType = ElementType.Trigger,
    override val id: TriggerId = TriggerId.Wearing,
    override val data: IElementData? = null,
    override val children: List<IElement> = listOf(),
) : IElement
