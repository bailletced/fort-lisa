rootProject.name = "Fort-Lisa"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

include(
    ":domain",
    ":use-cases",
)

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("kotlin", "1.9.22")
            version("serialization", "1.6.0")
            version("shadowjar", "8.1.1")
        }
    }
}
include("adapters")
include("adapters:serialization")
findProject(":adapters:serialization")?.name = "serialization"
include("adapters:deserializers")
include("adapters:repositories")
findProject(":adapters:repositories")?.name = "repositories"
include("use-cases:infra")
findProject(":use-cases:infra")?.name = "infra"
include("infrastructure")
include("adapters:flItems")
findProject(":adapters:flItems")?.name = "flItems"
include("adapters:flEntities")
findProject(":adapters:flEntities")?.name = "flEntities"
include("item")
include("item:equipment")
findProject(":item:equipment")?.name = "equipment"
include("stat")
include("shared")
include("item:gift")
findProject(":item:gift")?.name = "gift"
include("item:skill")
findProject(":item:skill")?.name = "skill"
