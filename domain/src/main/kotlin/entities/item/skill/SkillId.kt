package entities.item.skill

import entities.item.IItemEntityId
import entities.item.gift.GiftWill

enum class SkillId(val gift: GiftWill) : IItemEntityId {
    BurningHead(GiftWill.BurningHeart),
    BurningBall(GiftWill.BurningHeart),
    BurningCylinder(GiftWill.BurningHeart),
}
