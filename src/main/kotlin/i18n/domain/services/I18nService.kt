package i18n.domain.services

import java.util.*

class I18nService() {
    private var messages: Map<Locale, Properties>

    init {
        messages =
            mapOf(
                Locale.FRANCE to loadMessages(Locale.FRANCE),
            )
    }

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

    fun getMessage(
        locale: Locale,
        key: String,
        valueMap: Map<String, String>,
    ): String {
        var message = messages.getValue(locale).getProperty(key, "Message not found: $key")
        for ((key, value) in valueMap) {
            message = message.replace("{$key}", value)
        }
        return message
    }
}
