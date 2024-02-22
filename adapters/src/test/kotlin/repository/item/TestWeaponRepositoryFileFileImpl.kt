package repository.item

import entities.element.mechanic.*
import entities.element.trigger.TriggerClick
import entities.element.trigger.TriggerClickEntity
import entities.element.trigger.TriggerClickEntityData
import entities.item.gift.GiftCapacityEntity
import entities.item.gift.GiftWill
import entities.item.skill.SkillId
import entities.item.weapon.WeaponCategory
import entities.item.weapon.WeaponEntity
import entities.item.weapon.WeaponId
import entities.item.weapon.WeaponStat
import org.junit.Test
import service.deserializer.DeserializerServiceImpl
import service.file.FileReaderServiceResource
import kotlin.test.assertEquals

class TestWeaponRepositoryFileFileImpl {
    @Test
    internal fun find() {
        val limbOfWisdom =
            WeaponRepositoryFileImpl(
                FileReaderServiceResource(),
                DeserializerServiceImpl(WeaponEntity.serializer()),
            ).find(WeaponCategory.Staff, WeaponId.LimbOfWisdom)

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
