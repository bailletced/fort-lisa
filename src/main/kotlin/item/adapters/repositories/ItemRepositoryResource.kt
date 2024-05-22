package item.adapters.repositories

import item.domain.entities.IItem
import item.domain.entities.IItemEntityCategory
import item.domain.entities.IItemEntityId
import item.domain.gateways.repositories.IItemRepository
import item.domain.services.DeserializerService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import shared.services.file.FileReaderResourceService

class ItemRepositoryResource<T : IItem>(
    private val serializer: KSerializer<T>,
) : IItemRepository<T> {
    @OptIn(ExperimentalSerializationApi::class)
    override fun find(
        category: IItemEntityCategory,
        id: IItemEntityId,
    ): T {
        val json =
            FileReaderResourceService().read(
                "/item/${serializer.descriptor.serialName.substringAfterLast('.')}/${category.toString()
                    .replaceFirstChar { it.lowercase() }}/$id.json",
            )
        return DeserializerService(serializer).deserialize(json)
    }
}
