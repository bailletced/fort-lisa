package formula.domain

import com.notkamui.keval.Keval
import stat.domain.entities.StatPlayer

class FormulaManager(
    private val mapFormula: Map<String, String>,
) {
    fun getFormula(
        attribute: EFormulaAttribute,
        id: String?,
    ): String {
        return mapFormula["$attribute${if (id !== null) "-$id" else ""}"]!!
    }

    fun evaluate(
        attribute: EFormulaAttribute,
        id: String?,
        player: StatPlayer,
    ): Double {
        val formula = getFormula(attribute, id)
        if (formula.isNotEmpty()) {
            return evaluate(formula, player)
        }
        throw Exception("no formula found with $attribute-$id")
    }

    fun evaluate(
        formula: String,
        player: StatPlayer,
    ): Double {
        val replacedExpression = replacePlayerStats(formula, player)
        val exprDetectorRegex = Regex("<([a-zA-Z]+\\.[a-zA-Z]+)>")
        val matches = exprDetectorRegex.findAll(replacedExpression)
        if (matches.count() > 0) {
            throw Exception("formula $replacedExpression is not entirely replaced")
        }
        return Keval.eval(replacedExpression)
    }

    private fun replacePlayerStats(
        formula: String,
        player: StatPlayer,
    ): String {
        val playerStatsRegex = Regex("<player\\.([a-zA-Z]+)>")
        return playerStatsRegex.replace(formula) { matchResult ->
            val stat = matchResult.groupValues[1]
            when (stat) {
                "attack" -> player.attack.toString()
                "defense" -> player.defence.toString()
                else -> throw Exception("unknown player stat $stat")
            }
        }
    }
}
