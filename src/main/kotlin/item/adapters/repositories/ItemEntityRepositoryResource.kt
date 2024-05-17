package item.adapters.repositories

import item.domain.entities.IItemEntity
import item.domain.entities.IItemEntityCategory
import item.domain.entities.IItemEntityId
import item.domain.entities.ItemType
import item.domain.entities.equipment.Equipment
import item.domain.entities.skill.Skill
import item.domain.gateways.repositories.IItemEntityRepository
import item.domain.services.DeserializerService
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer
import utils.file.FileReaderResource

class ItemEntityRepositoryResource<T : IItemEntity>(
) : IItemEntityRepository<T> {
    @OptIn(InternalSerializationApi::class)
    override fun find(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T {
        val json =
            FileReaderResource().read(
                "/item/${type.toString().lowercase()}/${category.toString()
                    .replaceFirstChar { it.lowercase() }}/$id.json",
            )

        val serializer: KSerializer<Equipment> = Equipment::class.serializer()

        return DeserializerService(serializer).deserialize(json) as T
    }
}
