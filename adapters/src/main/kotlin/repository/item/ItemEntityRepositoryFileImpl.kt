package repository.item

import entities.item.IItemEntity
import entities.item.IItemEntityCategory
import entities.item.IItemEntityId
import entities.item.ItemType
import gateways.repository.item.IItemEntityRepository
import gateways.service.deserializer.DeserializerService
import gateways.service.file.IFileReaderService

class ItemEntityRepositoryFileImpl<T : IItemEntity>(
    private val fileReaderService: IFileReaderService,
    private val deserializerService: DeserializerService<T>,
) : IItemEntityRepository<T> {
    override fun find(
        type: ItemType,
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T {
        val json =
            fileReaderService.read(
                "/item/${type.toString().lowercase()}/${category.toString()
                    .replaceFirstChar { it.lowercase() }}/$id.json",
            )

        return deserializerService.deserialize(json)
    }
}
