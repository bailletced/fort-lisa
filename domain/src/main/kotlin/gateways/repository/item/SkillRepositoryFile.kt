package gateways.repository.item

import entities.item.gift.GiftWill
import entities.item.skill.SkillEntity
import entities.item.skill.SkillId
import gateways.service.file.IFileReaderService

abstract class SkillRepositoryFile(
    val fileReaderService: IFileReaderService,
) {
    abstract fun find(
        category: GiftWill,
        id: SkillId,
    ): SkillEntity?
}
