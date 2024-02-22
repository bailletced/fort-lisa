package entities.element.mechanic

import entities.element.ElementType
import entities.element.IElement
import entities.element.IElementData
import kotlinx.serialization.Serializable

@Serializable
data class MechanicImmunityEntity(
    override val type: ElementType = ElementType.Mechanic,
    override val id: MechanicId = MechanicId.Immunity,
    override val data: MechanicImmunityEntityData,
    override val children: List<IElement> = listOf(),
) : IElement {
    override fun toString(): String = "$type $data $children"
}

@Serializable
data class MechanicImmunityEntityData(
    val immunityId: MechanicImmunityId,
    val amount: String,
) : IElementData

enum class MechanicImmunityId {
    All,
    Fire,
    Fall,
}
