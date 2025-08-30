plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach { target ->
        target.binaries.framework {
            baseName = "KMPChartsSample"
            isStatic = true
        }
    }

    sourceSets {
        iosMain.dependencies {
            implementation(projects.samples.sampleCommonUi)

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
        }
    }
}