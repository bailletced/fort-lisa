import entities.DElementSerializer
import entities.trigger.TriggerWearingEntity
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertNotNull

internal class TestDeserializeElement {
    val format =
        Json {
            isLenient = true
            ignoreUnknownKeys = false
        }

    @Test
    internal fun testDeserialize() {
        val json =
            """
             {
               "type": "Trigger",
               "id": "Wearing",
               "data": null,
               "children": [
                 {
                   "type": "Mechanic",
                   "id": "Skill",
                   "data": {
                     "action": "Give",
                     "skillId": "BurningHead"
                   }
                 },
                 {
                   "type": "Mechanic",
                   "id": "Immunity",
                   "data": {
                     "immunityId": "Fire",
                     "amount": "0.2"
                   }
                }   
             ]
            }
            """.trimIndent()

        val result = format.decodeFromString(DElementSerializer, json) as TriggerWearingEntity
        assertNotNull(result)
    }
}
