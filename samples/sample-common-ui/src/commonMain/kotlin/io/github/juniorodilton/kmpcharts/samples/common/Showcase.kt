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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import io.github.juniorodilton.kmpcharts.compose.BaselineBarChart
import io.github.juniorodilton.kmpcharts.core.DataPoint
import io.github.juniorodilton.kmpcharts.core.Series

private val SeriesA = Series(
    name = "POC – Baseline Bar Chart",
    points = listOf(
        DataPoint("Jan 25", 30f),
        DataPoint("Fev 25", 40f),
        DataPoint("Mar 25", -12f),
        DataPoint("Abr 25", 55f),
        DataPoint("Mai 25", -22f),
        DataPoint("Jun 25", 15f),
    )
)

private val SeriesB = Series(
    name = "POC – Baseline Bar Chart",
    points = listOf(
        DataPoint("Jul 25", 10f),
        DataPoint("Ago 25", 0f),
        DataPoint("Set 25", -30f),
        DataPoint("Out 25", -15f),
        DataPoint("Nov 25", 42f),
        DataPoint("Dez 25", 70f),
    )
)

@Composable
fun ShowcaseApp() {
    MaterialTheme {
        var useAlt by rememberSaveable { mutableStateOf(false) }
        ShowcaseScreen(
            useAlt = useAlt,
            onToggleDataset = { useAlt = !useAlt }
        )
    }
}

@Composable
fun ShowcaseScreen(
    useAlt: Boolean,
    onToggleDataset: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "KMPCharts - Showcase",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                actions = {
                    IconButton(
                        onClick = onToggleDataset,
                        modifier = Modifier.semantics { contentDescription = "Trocar dataset" }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Refresh,
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
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
            val series = if (useAlt) SeriesB else SeriesA
            BaselineBarChart(
                series = series,
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("baselineBarChart")
                    .semantics { contentDescription = "Gráfico de barras com baseline" }
            )
        }
    }
}