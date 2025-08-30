import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.composeCompiler)
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "app.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(projects.samples.sampleCommonUi)

                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
            }
        }
    }
}
