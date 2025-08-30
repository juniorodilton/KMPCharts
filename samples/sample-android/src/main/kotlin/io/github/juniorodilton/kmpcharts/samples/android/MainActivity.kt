package io.github.juniorodilton.kmpcharts.samples.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.juniorodilton.kmpcharts.samples.common.ShowcaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ShowcaseApp() }
    }
}
