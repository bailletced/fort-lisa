package utils

import formula.domain.FormulaManager
import item.domain.entities.IItemEntity
import i18n.domain.services.I18nService
import stat.domain.entities.StatPlayer
import java.util.*

class ItemUtils(
    private val itemEntity: IItemEntity,
    private val i18nService: I18nService
) {
    fun generateLore(
        playerStat: StatPlayer,
    ): List<String> {

        val i18nString =
            StringUtils.i18nKeyFromStrings(
                listOf(
                    itemEntity.type.toString(),
                    itemEntity.category.toString(),
                    itemEntity.id.toString(),
                ),
                "item.",
            )

        val loreItem = if (itemEntity.mapFormula?.isEmpty() == false) {
            FormulaManager(itemEntity.mapFormula!!)
        } else null

        return listOf(
            i18nService.getMessage(Locale.FRANCE, "$i18nString.title"),
//            FormulaManager(itemEntity.mapFormula)i18nService.getMessage(Locale.FRANCE, "$i18nString.lore"),
        )
    }

}