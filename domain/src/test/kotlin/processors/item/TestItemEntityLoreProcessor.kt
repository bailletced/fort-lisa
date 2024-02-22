package processors.item

import entities.item.gift.GiftWill
import entities.item.skill.SkillEntity
import entities.item.skill.SkillId
import entities.item.skill.SkillStat
import org.junit.Test
import service.i18n.I18nServiceImpl

class TestItemEntityLoreProcessor {
    @Test
    fun testProcessLore() {
        val i18nService = I18nServiceImpl()
        val skillEntity =
            SkillEntity(
                category = GiftWill.BurningHeart,
                id = SkillId.BurningHead,
                material = mapOf(GiftWill.Base to "torch"),
                stat = SkillStat(),
            )
        val processor = ItemEntityLoreProcessor(i18nService, skillEntity)
        processor.generate()
    }
}
