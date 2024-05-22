package item.domain.gateways.repositories

import item.domain.entities.IItem
import item.infra.FlItem

interface IFlItemRepository {
    fun find(uuid: String): FlItem<IItem>?

    fun save(
        uuid: String,
        flItem: FlItem<IItem>,
    )
}
