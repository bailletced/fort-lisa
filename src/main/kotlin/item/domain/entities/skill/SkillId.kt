package item.domain.entities.skill

import item.domain.entities.IItemEntityId
import item.domain.entities.gift.GiftWill

enum class SkillId(val gift: GiftWill) : IItemEntityId {
    BurningHead(GiftWill.BurningHeart),
    BurningBall(GiftWill.BurningHeart),
    BurningCylinder(GiftWill.BurningHeart),
}
