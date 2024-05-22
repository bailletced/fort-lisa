package item.adapters.repositories

import item.domain.entities.IItem
import item.domain.gateways.repositories.IFlItemRepository
import item.infra.FlItem

class FlItemRepositoryMemory : IFlItemRepository {
    private var memoryStorage: Map<String, FlItem<IItem>> = mapOf()

    override fun find(uuid: String): FlItem<IItem>? {
        return memoryStorage.get(uuid)
    }

    override fun save(
        uuid: String,
        flItem: FlItem<IItem>,
    ) {
        TODO("Not yet implemented")
    }
}
