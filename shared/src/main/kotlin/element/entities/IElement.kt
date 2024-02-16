package element.entities

import element.entities.mechanic.MechanicId
import element.entities.mechanic.MechanicImmunityEntity
import element.entities.mechanic.MechanicSkillEntity
import element.entities.trigger.TriggerClickEntity
import element.entities.trigger.TriggerId
import element.entities.trigger.TriggerWearingEntity
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

interface IElementId

interface IElementData

@Serializable(with = DElementSerializer::class)
interface IElement {
    val type: ElementType
    val id: IElementId
    val data: IElementData?
    val children: List<IElement>?
}

object DElementSerializer : JsonContentPolymorphicSerializer<IElement>(IElement::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<IElement> {
        val jsonObject = element.jsonObject
        val type = jsonObject["type"]?.jsonPrimitive?.content
        val id = jsonObject["id"]?.jsonPrimitive?.content

        return when (type) {
            ElementType.Mechanic.toString() -> {
                when (id) {
                    MechanicId.Skill.toString() -> MechanicSkillEntity.serializer()
                    MechanicId.Immunity.toString() -> MechanicImmunityEntity.serializer()
                    else -> throw Exception("Serialization error $type: unknown id $id")
                }
            }
            ElementType.Trigger.toString() -> {
                when (id) {
                    TriggerId.Click.toString() -> TriggerClickEntity.serializer()
                    TriggerId.Wearing.toString() -> TriggerWearingEntity.serializer()
                    else -> throw Exception("Serialization error $type: unknown id $id")
                }
            }
            else -> throw Exception("Serialization error : unknown type $type")
        }
    }
}
