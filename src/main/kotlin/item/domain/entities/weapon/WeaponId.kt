package item.domain.entities.weapon

import item.domain.entities.IItemEntityId

enum class WeaponId(val category: WeaponCategory) : IItemEntityId {
    LimbOfWisdom(WeaponCategory.Staff),
}
