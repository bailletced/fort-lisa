package entities.item.weapon

import entities.item.EItemType
import entities.item.IItemEntityCategory

enum class WeaponCategory(val type: EItemType) : IItemEntityCategory {
    Bow(EItemType.Weapon),
    CrossBow(EItemType.Weapon),
    Sword(EItemType.Weapon),
    Staff(EItemType.Weapon),
}
