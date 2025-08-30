package io.github.juniorodilton.kmpcharts.samples.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.juniorodilton.kmpcharts.samples.common.ShowcaseApp

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KMPCharts — Desktop") {
        ShowcaseApp()
    }
}
