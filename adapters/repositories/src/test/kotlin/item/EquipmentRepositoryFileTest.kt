package item

import entity.StatEntity
import entity.item.equipment.EquipmentCategory
import entity.item.equipment.EquipmentEntity
import entity.item.equipment.EquipmentId
import entity.item.gift.GiftCapacityEntity
import entity.item.gift.GiftWill
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class EquipmentRepositoryFileTest {
    @Test
    internal fun testFind() {
        val laurelCrown = EquipmentRepositoryFile().find(EquipmentCategory.Helmet, EquipmentId.LaurelCrown)
        assertEquals(
            EquipmentEntity(
                category = EquipmentCategory.Helmet,
                id = EquipmentId.LaurelCrown,
                material = mapOf(GiftWill.BASE to "leather helmet"),
                tier = 1,
                giftCapacity =
                    GiftCapacityEntity(
                        1,
                        1,
                        1,
                    ),
                stat = StatEntity(defence = "2"),
            ),
            laurelCrown,
        )
    }
}
