package entities.item.fl

import entities.item.IItemEntity

class FlItem<T : IItemEntity>(
    val entity: T,
    val mcItem: IGameItemEntity,
)
