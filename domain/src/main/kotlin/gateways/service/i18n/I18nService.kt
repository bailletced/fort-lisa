package gateways.service.i18n

import entities.stat.IStatEntity
import java.util.Locale

interface I18nService {
    fun getMessage(
        locale: Locale,
        key: String,
    ): String

    fun getMessage(
        locale: Locale,
        key: String,
        valueMap: Map<String, String>,
    ): String

    fun getMessage(
        locale: Locale,
        key: String,
        stat: IStatEntity,
    ): String
}
