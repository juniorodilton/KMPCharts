package com.juniorodilton.kmpcharts.chart

import androidx.compose.runtime.Immutable

@Immutable
data class DataPoint(val label: String, val value: Float)

@Immutable
data class Series(
    val name: String,
    val points: List<DataPoint>
)
