package item.adapters.repositories

import item.domain.entities.IItemEntity
import item.domain.gateways.repositories.IFlItemRepository
import item.infra.FlItem

class FlItemEntityRepositoryMemory : IFlItemRepository {
    private var memoryStorage: Map<String, FlItem<IItemEntity>> = mapOf()

    override fun find(uuid: String): FlItem<IItemEntity>? {
        return memoryStorage.get(uuid)
    }

    override fun save(
        uuid: String,
        flItem: FlItem<IItemEntity>,
    ) {
        TODO("Not yet implemented")
    }
}
