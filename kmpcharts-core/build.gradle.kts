import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}
kotlin {
    androidTarget()
    jvm("desktop")
    iosX64(); iosArm64(); iosSimulatorArm64()
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs { browser() }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies { implementation(kotlin("test")) }
        }
    }
}
android {
    namespace = "io.github.juniorodilton.kmpcharts.core"
    compileSdk = 34
    defaultConfig { minSdk = 24 }
}