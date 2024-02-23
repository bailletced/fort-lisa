package entities.item.weapon

import entities.item.IItemEntityCategory
import entities.item.ItemType

enum class WeaponCategory(val type: ItemType) : IItemEntityCategory {
    Bow(ItemType.Weapon),
    CrossBow(ItemType.Weapon),
    Sword(ItemType.Weapon),
    Staff(ItemType.Weapon),
}
