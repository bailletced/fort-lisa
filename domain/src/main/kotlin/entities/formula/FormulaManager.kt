package entities.formula

import com.notkamui.keval.Keval
import entities.stat.StatPlayer

class FormulaManager(
    val mapFormula: Map<String, String>,
) {
    fun getFormula(
        keyword: EFormula,
        id: String?,
    ): String {
        return mapFormula.get("$keyword${if (id !== null) "-$id" else ""}")!!
    }

    fun evaluate(
        keyword: EFormula,
        id: String?,
        player: StatPlayer,
    ): Double {
        val formula = getFormula(keyword, id)
        if (formula !== null) {
            return evaluate(formula, player)
        }
        throw Exception("no formula found with $keyword-$id")
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
