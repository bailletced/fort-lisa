package gateways.repository.item

import entities.item.weapon.WeaponCategory
import entities.item.weapon.WeaponEntity
import entities.item.weapon.WeaponId
import gateways.service.file.IFileReaderService

abstract class WeaponRepositoryFile(
    val fileReaderService: IFileReaderService,
) {
    abstract fun find(
        category: WeaponCategory,
        id: WeaponId,
    ): WeaponEntity?
}
