package service

import org.junit.Test
import service.i18n.I18nServiceImpl
import java.util.Locale

class TestI18nServiceImpl {
    @Test
    internal fun test() {
        val i18nService = I18nServiceImpl()
        val message = i18nService.getMessage(Locale.FRANCE, "CountryName")
        println(message)
    }
}
