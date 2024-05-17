package utils

fun String.decapitalizeFirstChar(): String {
    return this[0].lowercase() + substring(1)
}

object StringUtils {
    fun decapitalizeFirstChar(text: String): String {
        return text[0].lowercase() + text.substring(1)
    }

    fun i18nKeyFromStrings(
        keys: List<String>,
        prefix: String = "",
    ): String {
        return prefix +
            keys.reduce { acc, key ->
                acc.decapitalizeFirstChar() + "." +
                    key.decapitalizeFirstChar()
            }
    }
}
