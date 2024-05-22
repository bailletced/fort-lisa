package shared.services.i18n

import org.junit.Test
import java.util.Locale
import kotlin.test.assertEquals

class TestI18nService {
    @Test
    internal fun testGetKey() {
        val i18nService = I18nService()
        val message = i18nService.getMessage(Locale.FRANCE, "test")
        assertEquals("Tête brûlée {attack}", message)
    }

    @Test
    internal fun testGetMessage() {
        val i18nService = I18nService()
        val message = i18nService.getMessage(Locale.FRANCE, "test")
        assertEquals("Tête brûlée {attack}", message)
    }

    @Test
    internal fun testGetMessageWithValueMap() {
        val i18nService = I18nService()
        val message =
            i18nService.getMessage(
                Locale.FRANCE,
                "test",
                mapOf
                    ("attack" to "20"),
            )
        assertEquals(message, "Tête brûlée 20")
    }
}
