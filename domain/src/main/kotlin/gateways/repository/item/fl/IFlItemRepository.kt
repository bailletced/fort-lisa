package gateways.repository.item.fl

import entities.item.IItemEntity
import entities.item.fl.FlItemEntity

interface IFlItemRepository {
    fun find(uuid: String): FlItemEntity<IItemEntity>?

    fun save(
        uuid: String,
        flItem: FlItemEntity<IItemEntity>,
    )
}
