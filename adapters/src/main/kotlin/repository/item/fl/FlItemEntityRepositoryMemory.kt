package repository.item.fl

import entities.item.IItemEntity
import entities.item.fl.FlItemEntity
import gateways.repository.item.fl.IFlItemRepository

class FlItemEntityRepositoryMemory() : IFlItemRepository {
    private var memoryStorage: Map<String, FlItemEntity<IItemEntity>> = mapOf()

    override fun find(uuid: String): FlItemEntity<IItemEntity>? {
        return memoryStorage.get(uuid)
    }

    override fun save(
        uuid: String,
        flItem: FlItemEntity<IItemEntity>,
    ) {
        TODO("Not yet implemented")
    }
}
