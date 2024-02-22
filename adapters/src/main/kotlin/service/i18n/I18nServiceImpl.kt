package service.i18n

import java.util.Locale
import java.util.Properties

class I18nServiceImpl() {
    private val messages: Map<Locale, Properties> =
        mapOf(
            Locale.FRANCE to loadMessages(Locale.FRANCE),
        )

    private fun loadMessages(locale: Locale): Properties {
        val messages = Properties()
        val resourcePath = "/i18n/$locale.properties"
        val resourceStream = javaClass.getResourceAsStream(resourcePath)
        messages.load(resourceStream)

        return messages
    }

    fun getMessage(
        locale: Locale,
        key: String,
    ): String {
        return messages.getValue(locale).getProperty(key, "Message not found: $key")
    }
}
