package gateways.repository.item.fl

import entities.item.IItemEntity
import entities.item.fl.FlItem

interface IFlItemRepository {
    fun find(uuid: String): FlItem<IItemEntity>?

    fun save(
        uuid: String,
        flItem: FlItem<IItemEntity>,
    )
}
