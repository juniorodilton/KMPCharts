plugins {
    alias(libs.plugins.composeCompiler)
    kotlin("jvm")
    id("org.jetbrains.compose")
    application
}

dependencies {
    implementation(projects.samples.sampleCommonUi)

    implementation(compose.desktop.currentOs)
}

application {
    mainClass.set("io.github.juniorodilton.kmpcharts.samples.desktop.MainKt")
}

kotlin {
    jvmToolchain(17)
}
