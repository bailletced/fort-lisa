package repository.item

import entities.item.weapon.WeaponCategory
import entities.item.weapon.WeaponEntity
import entities.item.weapon.WeaponId
import gateways.repository.item.WeaponRepositoryFile
import gateways.service.deserializer.DeserializerService
import gateways.service.file.IFileReaderService

class WeaponRepositoryFileImpl(
    fileReaderService: IFileReaderService,
    val deserializerService: DeserializerService<WeaponEntity>,
) : WeaponRepositoryFile(fileReaderService) {
    override fun find(
        category: WeaponCategory,
        id: WeaponId,
    ): WeaponEntity {
        val json = fileReaderService.read("/weapon/${category.toString().lowercase()}/$id.json")

        return deserializerService.deserialize(json)
    }
}
