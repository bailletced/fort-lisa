import adapters.repositorites.EquipmentRepositoryFile
import entities.*
import entities.mechanic.*
import entities.trigger.TriggerWearingEntity
import org.junit.Test
import kotlin.test.assertEquals

internal class TestEquipmentRepositoryFile {
    @Test
    internal fun testFind() {
        val laurelCrown = EquipmentRepositoryFile().find(EquipmentCategory.Helmet, EquipmentId.LaurelCrown)

        val expectedResult =
            (
                EquipmentEntity(
                    category = EquipmentCategory.Helmet,
                    id = EquipmentId.LaurelCrown,
                    material = mapOf(GiftWill.BASE to "leather helmet"),
                    tier = 1,
                    giftCapacity =
                        GiftCapacityEntity(
                            1,
                            1,
                            1,
                        ),
                    stat = EquipmentStat(defence = "2"),
                    elements =
                        listOf(
                            TriggerWearingEntity(
                                children =
                                    listOf(
                                        MechanicSkillEntity(
                                            data =
                                                MechanicSkillEntityData(
                                                    action = MechanicSkillEntityAction.Give,
                                                    skillId = SkillId.BurningHead,
                                                ),
                                        ),
                                        MechanicImmunityEntity(
                                            data =
                                                MechanicImmunityEntityData(
                                                    immunityId = MechanicImmunityId.Fire,
                                                    amount = "0.2",
                                                ),
                                        ),
                                    ),
                            ),
                        ),
                )
            )
        assertEquals(laurelCrown, expectedResult)
    }
}
