package item.infra

import item.domain.entities.IItemEntity

class FlItem<T : IItemEntity>(
    val entity: T,
    val mcItem: GameItemEntity,
)
