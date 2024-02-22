package repository.item

import entities.item.gift.GiftWill
import entities.item.skill.SkillEntity
import entities.item.skill.SkillId
import entities.item.skill.SkillStat
import org.junit.Test
import service.deserializer.DeserializerServiceImpl
import service.file.FileReaderServiceResource
import kotlin.test.assertEquals

class TestSkillRepositoryFileFileImpl {
    @Test
    internal fun find() {
        val burningHead =
            SkillRepositoryFileImpl(
                FileReaderServiceResource(),
                DeserializerServiceImpl(SkillEntity.serializer()),
            ).find(GiftWill.BurningHeart, SkillId.BurningHead)

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
}
