package io.github.juniorodilton.kmpcharts.samples.ios

import androidx.compose.ui.window.ComposeUIViewController
import io.github.juniorodilton.kmpcharts.samples.common.ShowcaseApp
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController =
    ComposeUIViewController { ShowcaseApp() }
