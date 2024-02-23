package entities.item.fl

import entities.item.IItemEntity

class FlItemEntity<T : IItemEntity>(
    val entity: T,
    val mcItem: IGameItemEntity,
)
