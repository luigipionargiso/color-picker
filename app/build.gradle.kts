plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.detekt)
}

android {
    namespace = "io.github.luigipionargiso.colorpicker"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "io.github.luigipionargiso.colorpicker"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "0.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                // R8 on the whole app: code shrinking, optimization, obfuscation and resource shrinking.
                enable = true
            }
        }
    }
    buildFeatures {
        compose = true
    }
    lint {
        // Warnings fail the build too, so they get fixed instead of piling up.
        warningsAsErrors = true
        abortOnError = true
        // "A newer version is available" checks: dependency updates are a separate job,
        // and the build shouldn't start failing just because a library released a new version.
        disable += setOf("GradleDependency", "NewerVersionAvailable", "AndroidGradlePluginVersion")
    }
}

// Compile Java and Kotlin with JDK 17 on every machine (downloaded through foojay if missing).
// This also sets the Java source/target compatibility and Kotlin's jvmTarget to 17.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

// Static analysis. Only our changes to detekt's defaults live in the config file.
detekt {
    buildUponDefaultConfig = true
    config.setFrom(rootProject.file("config/detekt/detekt.yml"))
}

// By default `check` runs the plain `detekt` task, which skips type resolution.
// Run the type-resolving tasks instead: some Compose rules need it, and detekt finds more with it.
tasks.named("check") {
    setDependsOn(dependsOn.filterNot { it is TaskProvider<*> && it.name == "detekt" })
    dependsOn("detektMain", "detektTest")
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    detektPlugins(libs.compose.rules.detekt)
}
