@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.juniorodilton.kmpcharts.samples.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.juniorodilton.kmpcharts.compose.BaselineBarChart
import io.github.juniorodilton.kmpcharts.core.DataPoint
import io.github.juniorodilton.kmpcharts.core.Series

@Composable
fun ShowcaseApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ShowcaseScreen()
        }
    }
}

@Composable
fun ShowcaseScreen() {
    var toggle by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "KMPCharts - Showcase",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                actions = {
                    IconButton(onClick = { toggle = !toggle }) {
                        Icon(Icons.Outlined.Refresh, contentDescription = "Trocar dataset")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DemoGroupedBar(toggle)
        }
    }
}

@Composable
private fun DemoGroupedBar(toggle: Boolean) {
    val sample = remember(toggle) {
        val data1 = listOf(
            DataPoint("Jan 25", 30f),
            DataPoint("Fev 25", 40f),
            DataPoint("Mar 25", -12f),
            DataPoint("Abr 25", 55f),
            DataPoint("Mai 25", -22f),
            DataPoint("Jun 25", 15f),
        )
        val data2 = listOf(
            DataPoint("Jul 25", 10f),
            DataPoint("Ago 25", 0f),
            DataPoint("Set 25", -30f),
            DataPoint("Out 25", -15f),
            DataPoint("Nov 25", 42f),
            DataPoint("Dez 25", 70f),
        )
        Series(
            name = "POC – Baseline Bar Chart",
            points = if (toggle) data2 else data1
        )
    }
    BaselineBarChart(series = sample)
}
