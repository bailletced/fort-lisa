
package item.adapters.repositories

import element.domain.entities.mechanic.*
import element.domain.entities.trigger.TriggerWearing
import item.domain.entities.ItemType
import item.domain.entities.equipment.Equipment
import item.domain.entities.equipment.EquipmentCategory
import item.domain.entities.equipment.EquipmentId
import item.domain.entities.gift.GiftCapacity
import item.domain.entities.gift.GiftWill
import item.domain.entities.skill.SkillId
import org.junit.Test
import stat.domain.entities.StatEquipment
import kotlin.test.assertEquals

class TestItemServiceFile {
    @Test
    internal fun findEquipment() {
        val laurelCrown =
            ItemRepositoryResource(Equipment.serializer()).find(
                ItemType.Equipment,
                category = EquipmentCategory.Helmet,
                id = EquipmentId.LaurelCrown,
            )

        val expectedResult =
            (
                Equipment(
                    category = EquipmentCategory.Helmet,
                    id = EquipmentId.LaurelCrown,
                    material = mapOf(GiftWill.Base to "leather helmet"),
                    tier = 1,
                    giftCapacity =
                        GiftCapacity(
                            1,
                            1,
                            1,
                        ),
                    stat = StatEquipment(defence = 2.0),
                    mapFormula = mapOf("EffectDamage-1" to "20 + 0.6 * <player.attack>"),
                    elements =
                        listOf(
                            TriggerWearing(
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

//    @Test
//    internal fun findSkill() {
//        val burningHead =
//            ItemServiceFile(
//                fileReaderService,
//                DeserializerServiceImpl(
//                    Skill
//                        .serializer(),
//                ),
//            ).find(ItemType.Skill, GiftWill.BurningHeart, SkillId.BurningHead)
//
//        val expectedResult =
//            (
//                Skill(
//                    category = GiftWill.BurningHeart,
//                    id = SkillId.BurningHead,
//                    material = mapOf(GiftWill.Base to "torch"),
//                    mapFormula = mapOf("EffectDamage-1" to "amount: 20 + 0.6 * <player.attack>"),
//                )
//            )
//
//        assertEquals(expectedResult, burningHead)
//    }
//
//    @Test
//    internal fun findWeapon() {
//        val limbOfWisdom =
//            ItemServiceFile(
//                fileReaderService,
//                DeserializerServiceImpl(
//                    Weapon
//                        .serializer(),
//                ),
//            ).find(ItemType.Weapon, WeaponCategory.Staff, WeaponId.LimbOfWisdom)
//
//        val expectedResult =
//            (
//                Weapon(
//                    category = WeaponCategory.Staff,
//                    id = WeaponId.LimbOfWisdom,
//                    material = mapOf(GiftWill.Base to "carrot on stick"),
//                    tier = 1,
//                    giftCapacity =
//                        GiftCapacity(
//                            1,
//                            1,
//                            1,
//                        ),
//                    elements =
//                        listOf(
//                            TriggerClickEntity(
//                                data =
//                                    TriggerClickEntityData(
//                                        TriggerClick.LeftClick,
//                                    ),
//                                children =
//                                    listOf(
//                                        MechanicSkillEntity(
//                                            data =
//                                                MechanicSkillEntityData(
//                                                    action = MechanicSkillEntityAction.Cast,
//                                                    skillId = SkillId.BurningBall,
//                                                ),
//                                        ),
//                                    ),
//                            ),
//                            TriggerClickEntity(
//                                data =
//                                    TriggerClickEntityData(
//                                        TriggerClick.RightClick,
//                                    ),
//                                children =
//                                    listOf(
//                                        MechanicSkillEntity(
//                                            data =
//                                                MechanicSkillEntityData(
//                                                    action = MechanicSkillEntityAction.Cast,
//                                                    skillId = SkillId.BurningCylinder,
//                                                ),
//                                        ),
//                                    ),
//                            ),
//                        ),
//                )
//            )
//        assertEquals(limbOfWisdom, expectedResult)
//    }
}
