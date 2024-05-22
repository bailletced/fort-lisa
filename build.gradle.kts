import tasks.i18n.I18nKeyGeneratorTask

plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.notkamui.libs:keval:1.0.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}

allprojects {
    group = "com.fort-lisa"
    version = "1.0-SNAPSHOT"
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    repositories {
        mavenCentral()
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
    }
}

tasks.register<I18nKeyGeneratorTask>("i18nEnum") {
    doFirst {
        copy {
            from("domain/src/main/resources/i18n")
            into("buildSrc/src/main/resources/i18n")
        }
    }
}
