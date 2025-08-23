package io.github.juniorodilton.kmpcharts.compose

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.juniorodilton.kmpcharts.core.Scale
import io.github.juniorodilton.kmpcharts.core.Series
import io.github.juniorodilton.kmpcharts.core.computeScale
import kotlin.math.abs

object BarChartDefaults {
    val PlotHeight = 160.dp
    val BarCorner = 6.dp
    const val BarWidthFraction = 0.6f
    val EnterAnimation = spring<Dp>(stiffness = Spring.StiffnessMediumLow)
}

@Composable
fun BaselineBarChart(
    series: Series,
    modifier: Modifier = Modifier,
    plotHeight: Dp = BarChartDefaults.PlotHeight,
    barWidthFraction: Float = BarChartDefaults.BarWidthFraction,
    showLabels: Boolean = true,
    positiveColor: Color = MaterialTheme.colorScheme.primary,
    negativeColor: Color = MaterialTheme.colorScheme.error,
) {
    val values = remember(series) { series.points.map { it.value } }
    val scale = remember(values) { computeScale(values) }
    val baselineDp = plotHeight * scale.baselineRatio

    Column(modifier) {
        // Área do gráfico
        Box(
            Modifier
                .fillMaxWidth()
                .height(plotHeight)
        ) {
            Row(Modifier.fillMaxSize()) {
                series.points.forEach { point ->
                    val v = point.value
                    val posTarget =
                        if (v > 0f && scale.posMax > 0f) baselineDp * (v / scale.posMax) else 0.dp
                    val negTarget =
                        if (v < 0f && scale.negMin < 0f)
                            (plotHeight - baselineDp) * (abs(v) / abs(scale.negMin))
                        else 0.dp

                    val posH by animateDpAsState(
                        posTarget,
                        label = "posH",
                        animationSpec = BarChartDefaults.EnterAnimation
                    )
                    val negH by animateDpAsState(
                        negTarget,
                        label = "negH",
                        animationSpec = BarChartDefaults.EnterAnimation
                    )

                    Column(
                        Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // acima do zero
                        Spacer(Modifier.height((baselineDp - posH).coerceAtLeast(0.dp)))
                        Box(
                            Modifier
                                .fillMaxWidth(barWidthFraction)
                                .height(posH)
                                .clip(RoundedCornerShape(BarChartDefaults.BarCorner))
                                .background(positiveColor)
                                .semantics { contentDescription = "${point.label}: ${point.value}" }
                        )
                        // abaixo do zero
                        Box(
                            Modifier
                                .fillMaxWidth(barWidthFraction)
                                .height(negH)
                                .clip(RoundedCornerShape(BarChartDefaults.BarCorner))
                                .background(negativeColor)
                        )
                    }
                }
            }

            // Linha do zero
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .offset(y = baselineDp)
                    .background(MaterialTheme.colorScheme.outlineVariant)
            )
        }

        if (showLabels) {
            Spacer(Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth()) {
                series.points.forEach { point ->
                    Text(
                        point.label,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}
