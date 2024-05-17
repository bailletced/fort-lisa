package item.domain.gateways.repositories

import item.domain.entities.IItemEntity
import item.infra.FlItem

interface IFlItemRepository {
    fun find(uuid: String): FlItem<IItemEntity>?

    fun save(
        uuid: String,
        flItem: FlItem<IItemEntity>,
    )
}
