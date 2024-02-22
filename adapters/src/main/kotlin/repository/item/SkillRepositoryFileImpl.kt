package repository.item

import entities.item.gift.GiftWill
import entities.item.skill.SkillEntity
import entities.item.skill.SkillId
import gateways.repository.item.SkillRepositoryFile
import gateways.service.deserializer.DeserializerService
import gateways.service.file.IFileReaderService
import java.util.*

class SkillRepositoryFileImpl(
    fileReaderService: IFileReaderService,
    val deserializerService: DeserializerService<SkillEntity>,
) : SkillRepositoryFile(fileReaderService) {
    override fun find(
        category: GiftWill,
        id: SkillId,
    ): SkillEntity {
        val json =
            fileReaderService.read(
                "/skill/${category.toString()
                    .replaceFirstChar { it.lowercase() }}/$id.json",
            )

        return deserializerService.deserialize(json)
    }
}
