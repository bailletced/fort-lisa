package gateways.repository.i18n

import java.util.Locale

interface I18nRepository {
    fun getMessage(
        locale: Locale,
        key: String,
    ): String
}
