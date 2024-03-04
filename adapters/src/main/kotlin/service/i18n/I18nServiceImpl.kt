package service.i18n

import entities.stat.IStatEntity
import gateways.repository.i18n.I18nRepository
import gateways.service.i18n.I18nService
import java.util.Locale

class I18nServiceImpl(val i18nRepository: I18nRepository) : I18nService {
    override fun getMessage(
        locale: Locale,
        key: String,
    ): String {
        return i18nRepository.getMessage(locale, key)
    }

    override fun getMessage(
        locale: Locale,
        key: String,
        valueMap: Map<String, String>,
    ): String {
        var message = i18nRepository.getMessage(locale, key)
        for ((key, value) in valueMap) {
            message = message.replace("{$key}", value)
        }
        return message
    }

    override fun getMessage(
        locale: Locale,
        key: String,
        stat: IStatEntity,
    ): String {
        TODO("Not yet implemented")
    }
}
