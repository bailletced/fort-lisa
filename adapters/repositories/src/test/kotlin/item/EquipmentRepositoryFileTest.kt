@file:Suppress("ktlint:standard:no-wildcard-imports")

package item

import element.mechanic.*
import element.trigger.TriggerWearingEntity
import entity.StatEntity
import entity.item.equipment.EquipmentCategory
import entity.item.equipment.EquipmentEntity
import entity.item.equipment.EquipmentId
import entity.item.gift.GiftCapacityEntity
import entity.item.gift.GiftWill
import entity.item.skill.SkillId
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class EquipmentRepositoryFileTest {
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
                    stat = StatEntity(defence = "2"),
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
