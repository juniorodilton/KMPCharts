package io.github.juniorodilton.kmpcharts.samples.web

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import io.github.juniorodilton.kmpcharts.samples.common.ShowcaseApp
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        ShowcaseApp()
    }
}
