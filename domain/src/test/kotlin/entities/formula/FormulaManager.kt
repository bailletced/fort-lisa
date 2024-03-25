package entities.formula

import entities.stat.StatPlayer
import org.junit.Test
import kotlin.test.assertEquals

class FormulaManagerTest {
    @Test
    internal fun getFormula() {
        val mapFormula =
            mapOf(
                "Damage-1" to "amount: 20 + 0.6 * <player.attack>",
                "EffectDamage-1" to "amount: 20 + 0.6 * <player.attack>",
            )

        val result = FormulaManager(mapFormula).getFormula(EFormula.Damage, "1")
        assertEquals("amount: 20 + 0.6 * <player.attack>", result)
    }

    @Test
    internal fun evaluate() {
        val mapFormula =
            mapOf(
                "Damage-1" to "20.0 + 0.6 * <player.attack>",
                "EffectDamage-1" to "20 + 0.6 * <player.attack>",
            )

        val playerStat = StatPlayer(attack = 20.0)
        val manager = FormulaManager(mapFormula)
        val attack = manager.evaluate(manager.getFormula(EFormula.Damage, "1"), playerStat)

        assertEquals(20 + 0.6 * 20, attack)
    }
}
