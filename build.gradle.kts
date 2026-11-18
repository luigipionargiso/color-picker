// Top-level build file: configuration shared by all modules.

buildscript {
    dependencies {
        // Use a newer Kotlin than the one AGP bundles for built-in Kotlin.
        // See https://developer.android.com/build/releases/agp-9-0-0-release-notes#runtime-dependency-on-kotlin-gradle-plugin
        classpath(libs.kotlin.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.spotless)
}

// Formatting for the whole repository, applied once here at the root.
// `./gradlew spotlessCheck` fails on badly formatted files; `./gradlew spotlessApply` fixes them.
//
// Targets name the folders explicitly instead of using a root-level `**`: Spotless lists them
// while Gradle configures the build, and a `**` walk would also enter .gradle/, whose lock files
// can't be read on Windows while the Gradle daemon holds them.
spotless {
    kotlin {
        // Modules at depth 1 (`app`) and 2 (`core/color`, from step 7).
        target("*/src/**/*.kt", "*/*/src/**/*.kt")
        // Rules and style come from .editorconfig.
        ktlint(libs.versions.ktlint.get())
    }
    kotlinGradle {
        target("*.gradle.kts", "*/build.gradle.kts", "*/*/build.gradle.kts")
        ktlint(libs.versions.ktlint.get())
    }
    format("misc") {
        target(
            "gradle/*.toml",
            ".github/**/*.yml",
            ".gitignore",
            "*/.gitignore",
            ".gitattributes",
            ".editorconfig"
        )
        trimTrailingWhitespace()
        endWithNewline()
    }
}
