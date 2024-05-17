package item.domain.entities.weapon

import item.domain.entities.IItemEntityCategory
import item.domain.entities.ItemType

enum class WeaponCategory(val type: ItemType) : IItemEntityCategory {
    Bow(ItemType.Weapon),
    CrossBow(ItemType.Weapon),
    Sword(ItemType.Weapon),
    Staff(ItemType.Weapon),
}
