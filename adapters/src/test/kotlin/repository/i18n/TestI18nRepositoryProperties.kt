package repository.i18n

import org.junit.Test
import java.util.Locale
import kotlin.test.assertEquals

class TestI18nRepositoryProperties {
    @Test
    internal fun testGetKey() {
        val i18nRepo = I18nRepositoryProperties()
        val message = i18nRepo.getMessage(Locale.FRANCE, "test")
        assertEquals("Tête brûlée {attack}", message)
    }
}
