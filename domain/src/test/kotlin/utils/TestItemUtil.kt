package utils

import entities.item.ItemType
import entities.item.equipment.Equipment
import entities.item.equipment.EquipmentCategory
import entities.item.equipment.EquipmentId
import entities.item.gift.GiftCapacity
import entities.item.gift.GiftWill
import entities.stat.StatEquipment
import entities.stat.StatPlayer
import gateways.service.i18n.I18nService
import org.junit.Test
import java.util.Locale

class TestItemUtil {
    val i18nServiceStub = object : I18nService {
        override fun getMessage(locale: Locale, key: String): String {
            return when (key) {
                "item.equipment.helmet.laurelCrown.title" -> "Couronne de Laurier"
                else -> "Clé inconnue"
            }
        }

        override fun getMessage(locale: Locale, key: String, valueMap: Map<String, String>): String {
            return when (key) {
                "item.equipment.helmet.laurelCrown.lore" -> "inflige <formula.attack-1> dégâts..."
                else -> "Clé inconnue"
            }
        }
    }


    @Test
    internal fun generateLore() {
        val equipment = Equipment(
            type = ItemType.Equipment,
            category = EquipmentCategory.Helmet,
            id = EquipmentId.LaurelCrown,
            elements = listOf(),
            giftCapacity = GiftCapacity(will = 0, intellect = 0, memory = 0),
            material = mapOf(GiftWill.Base to "something"),
            tier = 0,
            stat = StatEquipment()
        )
        val playerStat =
            StatPlayer(
                attack = 20.0,
            )

        val lore =
            ItemUtils(
                equipment,
                i18nServiceStub
            ).generateLore(playerStat)

        println(lore)
    }
}