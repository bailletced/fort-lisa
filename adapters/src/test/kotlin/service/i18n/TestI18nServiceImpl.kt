package service.i18n

import org.junit.Test
import repository.i18n.I18nRepositoryProperties
import java.util.Locale
import kotlin.test.assertEquals

class TestI18nServiceImpl {
    val i18nRepoProperies = I18nRepositoryProperties()
    val i18nServiceImpl = I18nServiceImpl(i18nRepoProperies)

    @Test
    internal fun testGetMessage() {
        val message = i18nServiceImpl.getMessage(Locale.FRANCE, "test")
        assertEquals("Tête brûlée {attack}", message)
    }

    @Test
    internal fun testGetMessageWithValueMap() {
        val message =
            i18nServiceImpl.getMessage(
                Locale.FRANCE,
                "test",
                mapOf
                    ("attack" to "20"),
            )
        assertEquals(message, "Tête brûlée 20")
    }
}
