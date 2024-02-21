plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":item"))
    implementation(project(":item:gift"))
    implementation(project(":item:skill"))
    implementation(project(":element"))
    implementation(project(":shared"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}
