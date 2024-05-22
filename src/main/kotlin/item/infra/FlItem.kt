package item.infra

import item.domain.entities.IItem

class FlItem<T : IItem>(
    val entity: T,
    val mcItem: GameItemEntity,
)
