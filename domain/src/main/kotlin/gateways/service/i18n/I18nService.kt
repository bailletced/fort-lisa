package gateways.service.i18n

import java.util.Locale

interface I18nService {
    fun getMessage(
        locale: Locale,
        key: String,
    ): String
}
