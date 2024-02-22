package processors.item

import entities.item.IItemEntity
import gateways.service.i18n.I18nService
import java.util.Locale

fun String.decapitalizeFirstChar(): String {
    if (isEmpty()) {
        return this
    }

    val firstChar = this[0].toLowerCase()
    return firstChar + substring(1)
}

class ItemEntityLoreProcessor(val i18nService: I18nService, val itemEntity: IItemEntity) {
    fun generate(): List<String> {
        val keyTitle = transformKey(itemEntity, "title")
        val keyLore = transformKey(itemEntity, "lore")

        println(keyTitle)
        println(i18nService.getMessage(Locale.FRANCE, keyTitle))

        return listOf()
    }

    private fun transformKey(
        itemEntity: IItemEntity,
        key: String,
    ): String {
        return "item.${itemEntity.type.toString().decapitalizeFirstChar()}.${itemEntity.category.toString().decapitalizeFirstChar()}.${itemEntity.id.toString().decapitalizeFirstChar()}.$key"
    }
}
