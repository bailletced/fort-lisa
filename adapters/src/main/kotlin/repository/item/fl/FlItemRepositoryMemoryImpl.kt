package repository.item.fl

import entities.item.fl.IFlItemEntity
import gateways.repository.item.fl.FlItemRepositoryMemory

class FlItemRepositoryMemoryImpl(
    private val memoryStorage: Map<String, IFlItemEntity>,
) : FlItemRepositoryMemory {
    override fun find(uuid: String): IFlItemEntity? {
        return memoryStorage.get(uuid)
    }
}
