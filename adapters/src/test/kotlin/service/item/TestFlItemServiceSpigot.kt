package service.item

import entities.item.ItemType
import entities.item.equipment.EquipmentCategory
import entities.item.equipment.EquipmentEntity
import entities.item.equipment.EquipmentId
import entities.player.PlayerStat
import org.junit.Test
import repository.i18n.I18nRepositoryProperties
import repository.item.ItemEntityRepositoryFileImpl
import repository.item.fl.FlItemEntityRepositoryMemory
import service.deserializer.DeserializerServiceImpl
import service.file.FileReaderServiceResource
import service.i18n.I18nServiceImpl

class TestFlItemServiceSpigot {
    val i18nService = I18nServiceImpl(I18nRepositoryProperties())
    val flItemEntityRepo = FlItemEntityRepositoryMemory()
    val equipmentEntityRepo =
        ItemEntityRepositoryFileImpl(FileReaderServiceResource(), DeserializerServiceImpl(EquipmentEntity.serializer()))

    val flItemServiceSpigot =
        FlItemServiceSpigot(
            i18nService = i18nService,
            itemEntityRepo = equipmentEntityRepo,
            flItemRepo = flItemEntityRepo,
        )

    @Test
    internal fun generateLore() {
        val playerStat =
            PlayerStat(
                attack = "20",
            )

        val lore =
            flItemServiceSpigot.generateLore(
                equipmentEntityRepo.find(ItemType.Equipment, EquipmentCategory.Helmet, EquipmentId.LaurelCrown),
                playerStat,
            )
        println(lore)
    }
}
