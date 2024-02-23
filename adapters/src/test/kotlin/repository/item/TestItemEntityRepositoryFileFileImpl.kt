
package repository.item

import entities.element.mechanic.*
import entities.element.trigger.TriggerClick
import entities.element.trigger.TriggerClickEntity
import entities.element.trigger.TriggerClickEntityData
import entities.element.trigger.TriggerWearingEntity
import entities.item.ItemType
import entities.item.equipment.EquipmentCategory
import entities.item.equipment.EquipmentEntity
import entities.item.equipment.EquipmentId
import entities.item.equipment.EquipmentStat
import entities.item.gift.GiftCapacityEntity
import entities.item.gift.GiftWill
import entities.item.skill.SkillEntity
import entities.item.skill.SkillId
import entities.item.skill.SkillStat
import entities.item.weapon.WeaponCategory
import entities.item.weapon.WeaponEntity
import entities.item.weapon.WeaponId
import entities.item.weapon.WeaponStat
import org.junit.Test
import service.deserializer.DeserializerServiceImpl
import service.file.FileReaderServiceResource
import kotlin.test.assertEquals

class TestItemEntityRepositoryFileFileImpl {
    val fileReaderService = FileReaderServiceResource()

    @Test
    internal fun findEquipment() {
        val laurelCrown =
            ItemEntityRepositoryFileImpl(
                fileReaderService,
                DeserializerServiceImpl(
                    EquipmentEntity
                        .serializer(),
                ),
            ).find(
                ItemType.Equipment,
                category = EquipmentCategory.Helmet,
                id = EquipmentId.LaurelCrown,
            )

        val expectedResult =
            (
                EquipmentEntity(
                    category = EquipmentCategory.Helmet,
                    id = EquipmentId.LaurelCrown,
                    material = mapOf(GiftWill.Base to "leather helmet"),
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

    @Test
    internal fun findSkill() {
        val burningHead =
            ItemEntityRepositoryFileImpl(
                fileReaderService,
                DeserializerServiceImpl(
                    SkillEntity
                        .serializer(),
                ),
            ).find(ItemType.Skill, GiftWill.BurningHeart, SkillId.BurningHead)

        val expectedResult =
            (
                SkillEntity(
                    category = GiftWill.BurningHeart,
                    id = SkillId.BurningHead,
                    material = mapOf(GiftWill.Base to "torch"),
                    stat = SkillStat(attack = "20 + 0.6 * <player.attack>"),
                )
            )
        assertEquals(burningHead, expectedResult)
    }

    @Test
    internal fun findWeapon() {
        val limbOfWisdom =
            ItemEntityRepositoryFileImpl(
                fileReaderService,
                DeserializerServiceImpl(
                    WeaponEntity
                        .serializer(),
                ),
            ).find(ItemType.Weapon, WeaponCategory.Staff, WeaponId.LimbOfWisdom)

        val expectedResult =
            (
                WeaponEntity(
                    category = WeaponCategory.Staff,
                    id = WeaponId.LimbOfWisdom,
                    material = mapOf(GiftWill.Base to "carrot on stick"),
                    tier = 1,
                    giftCapacity =
                        GiftCapacityEntity(
                            1,
                            1,
                            1,
                        ),
                    stat = WeaponStat(attack = "2"),
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
