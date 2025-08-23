package com.juniorodilton.kmpcharts.chart

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Insights
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CardDefaults
import io.github.juniorodilton.kmpcharts.compose.BaselineBarChart
import io.github.juniorodilton.kmpcharts.core.DataPoint
import io.github.juniorodilton.kmpcharts.core.Series

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChartSampleScreen() {
    var toggle by remember { mutableStateOf(false) }

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

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("KMPCharts – POC") },
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Outlined.Insights, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("BaselineBarChart (positivos + negativos)", style = MaterialTheme.typography.titleMedium)
                    }
                    Spacer(Modifier.height(12.dp))
                    BaselineBarChart(series = sample)
                }
            }
            Spacer(Modifier.height(12.dp))
            Text(
                "Kotlin Multiplatform + Compose Multiplatform • barras animadas • suporte a valores negativos",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
