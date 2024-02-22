package entities.item.weapon

import entities.item.IItemEntityId

enum class WeaponId(val category: WeaponCategory) : IItemEntityId {
    LimbOfWisdom(WeaponCategory.Staff),
}
