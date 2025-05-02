pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()

    }

    plugins{
        //id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
        //id("org.jetbrains.kotlin.plugin.serialization") version "2.0.21" apply false
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
//enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

rootProject.name = "android-clean-arch-storeapp"
include(":clean arch")
