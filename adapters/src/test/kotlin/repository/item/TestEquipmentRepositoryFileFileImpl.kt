package repository.item

import entities.element.mechanic.*
import entities.element.trigger.TriggerWearingEntity
import entities.item.equipment.EquipmentCategory
import entities.item.equipment.EquipmentEntity
import entities.item.equipment.EquipmentId
import entities.item.equipment.EquipmentStat
import entities.item.gift.GiftCapacityEntity
import entities.item.gift.GiftWill
import entities.item.skill.SkillId
import org.junit.Test
import service.deserializer.DeserializerServiceImpl
import service.file.FileReaderServiceResource
import kotlin.test.assertEquals

class TestEquipmentRepositoryFileFileImpl {
    @Test
    internal fun find() {
        val laurelCrown =
            EquipmentRepositoryFileImpl(
                FileReaderServiceResource(),
                DeserializerServiceImpl(EquipmentEntity.serializer()),
            ).find(EquipmentCategory.Helmet, EquipmentId.LaurelCrown)

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
}
