plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
}

dependencies {
    implementation(project(":item"))
    implementation(project(":shared"))
    implementation(project(":item:gift"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}