
package service.item

import entities.element.mechanic.*
import entities.element.trigger.TriggerClick
import entities.element.trigger.TriggerClickEntity
import entities.element.trigger.TriggerClickEntityData
import entities.element.trigger.TriggerWearing
import entities.item.ItemType
import entities.item.equipment.Equipment
import entities.item.equipment.EquipmentCategory
import entities.item.equipment.EquipmentId
import entities.item.gift.GiftCapacity
import entities.item.gift.GiftWill
import entities.item.skill.Skill
import entities.item.skill.SkillId
import entities.item.weapon.Weapon
import entities.item.weapon.WeaponCategory
import entities.item.weapon.WeaponId
import entities.stat.StatEquipment
import org.junit.Test
import service.deserializer.DeserializerServiceImpl
import service.file.FileReaderServiceResource
import kotlin.test.assertEquals

class TestItemServiceFile {
    val fileReaderService = FileReaderServiceResource()

    @Test
    internal fun findEquipment() {
        val laurelCrown =
            ItemServiceFile(
                fileReaderService,
                DeserializerServiceImpl(
                    Equipment.serializer(),
                ),
            ).find(
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

    @Test
    internal fun findSkill() {
        val burningHead =
            ItemServiceFile(
                fileReaderService,
                DeserializerServiceImpl(
                    Skill
                        .serializer(),
                ),
            ).find(ItemType.Skill, GiftWill.BurningHeart, SkillId.BurningHead)

        val expectedResult =
            (
                Skill(
                    category = GiftWill.BurningHeart,
                    id = SkillId.BurningHead,
                    material = mapOf(GiftWill.Base to "torch"),
                    mapFormula = mapOf("EffectDamage-1" to "amount: 20 + 0.6 * <player.attack>"),
                )
            )

        assertEquals(expectedResult, burningHead)
    }

    @Test
    internal fun findWeapon() {
        val limbOfWisdom =
            ItemServiceFile(
                fileReaderService,
                DeserializerServiceImpl(
                    Weapon
                        .serializer(),
                ),
            ).find(ItemType.Weapon, WeaponCategory.Staff, WeaponId.LimbOfWisdom)

        val expectedResult =
            (
                Weapon(
                    category = WeaponCategory.Staff,
                    id = WeaponId.LimbOfWisdom,
                    material = mapOf(GiftWill.Base to "carrot on stick"),
                    tier = 1,
                    giftCapacity =
                        GiftCapacity(
                            1,
                            1,
                            1,
                        ),
                    elements =
                        listOf(
                            TriggerClickEntity(
                                data =
                                    TriggerClickEntityData(
                                        TriggerClick.LeftClick,
                                    ),
                                children =
                                    listOf(
                                        MechanicSkillEntity(
                                            data =
                                                MechanicSkillEntityData(
                                                    action = MechanicSkillEntityAction.Cast,
                                                    skillId = SkillId.BurningBall,
                                                ),
                                        ),
                                    ),
                            ),
                            TriggerClickEntity(
                                data =
                                    TriggerClickEntityData(
                                        TriggerClick.RightClick,
                                    ),
                                children =
                                    listOf(
                                        MechanicSkillEntity(
                                            data =
                                                MechanicSkillEntityData(
                                                    action = MechanicSkillEntityAction.Cast,
                                                    skillId = SkillId.BurningCylinder,
                                                ),
                                        ),
                                    ),
                            ),
                        ),
                )
            )
        assertEquals(limbOfWisdom, expectedResult)
    }
}
