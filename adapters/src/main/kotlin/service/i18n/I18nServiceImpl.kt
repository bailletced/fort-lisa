package service.i18n

import gateways.service.i18n.I18nService
import java.util.Locale
import java.util.Properties

class I18nServiceImpl() : I18nService {
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

    override fun getMessage(
        locale: Locale,
        key: String,
    ): String {
        return messages.getValue(locale).getProperty(key, "Message not found: $key")
    }

    fun getMessage(
        locale: Locale,
        key: String,
        params: Map<String, String>,
    ): String {
        var message = messages.getValue(locale).getProperty(key, "Message not found: $key")
        for ((key, value) in params) {
            message = message.replace("{$key}", value)
        }
        return message
    }
}
