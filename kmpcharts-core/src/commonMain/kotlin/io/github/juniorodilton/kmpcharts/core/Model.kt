package io.github.juniorodilton.kmpcharts.core


data class DataPoint(val label: String, val value: Float)

data class Series(
    val name: String,
    val points: List<DataPoint>
)
