package service.i18n

import org.junit.Test
import java.util.Locale
import kotlin.test.assertEquals

class TestI18nServiceImpl {
    @Test
    internal fun testGetKey() {
        val i18nService = I18nServiceImpl()
        val message = i18nService.getMessage(Locale.FRANCE, "item.skill.burningHeart.burningHead.title")
        assertEquals(message, "Tête brûléeeeee {attack}")
    }

    @Test
    internal fun testGetKeyWithValue() {
        val i18nService = I18nServiceImpl()
        val message = i18nService.getMessage(Locale.FRANCE, "item.skill.burningHeart.burningHead.title", mapOf("attack" to "20"))
        assertEquals(message, "Tête brûléeeeee 20")
    }
}
