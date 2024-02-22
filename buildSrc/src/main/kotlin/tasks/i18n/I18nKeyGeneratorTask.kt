package tasks.i18n

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.configurationcache.extensions.capitalized
import java.io.File
import java.util.Properties

open class I18nKeyGeneratorTask : DefaultTask() {
    @TaskAction
    fun run() {
        val enumTargetFile = File("${project.rootProject.projectDir}/adapters/src/main/kotlin/service/i18n/EI18nKeys.kt")

        val messages = Properties()
        val resourcePath = "/i18n/fr_FR.properties"
        val resourceStream = javaClass.getResourceAsStream(resourcePath)
        messages.load(resourceStream)

        val enumContent =
            buildString {
                appendLine("package service.i18n\n")
                appendLine("enum class EI18nKeys(val key: String) {")

                messages.forEach { key, _ ->
                    val enumKey = toCamelCase(key.toString().replace('.', '_'))
                    appendLine("    $enumKey(\"$key\"),")
                }

                appendLine("}")
            }

        enumTargetFile.writeText(enumContent)
    }

    private fun toCamelCase(key: String): String {
        var result = ""
        val parts = key.split('_')
        for (element in parts) {
            result = "$result${element.capitalized()}"
        }
        return result
    }
}
