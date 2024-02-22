package gateways.repository.item.fl

import entities.item.fl.IFlItemEntity

interface FlItemRepositoryMemory {
    fun find(uuid: String): IFlItemEntity?
}
