package repository.i18n

import gateways.repository.i18n.I18nRepository
import java.util.Locale
import java.util.Properties

class I18nRepositoryProperties : I18nRepository {
    private var messages: Map<Locale, Properties>
    constructor() {
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

    override fun getMessage(
        locale: Locale,
        key: String,
    ): String {
        return messages.getValue(locale).getProperty(key, "Message not found: $key")
    }
}
