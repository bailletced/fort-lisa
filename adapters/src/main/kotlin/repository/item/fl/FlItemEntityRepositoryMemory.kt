package repository.item.fl

import entities.item.IItemEntity
import entities.item.fl.FlItem
import gateways.repository.item.fl.IFlItemRepository

class FlItemEntityRepositoryMemory() : IFlItemRepository {
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
