package io.github.juniorodilton.kmpcharts.core

import kotlin.math.max
import kotlin.math.min

data class Scale(
    val posMax: Float,
    val negMin: Float,
    val baselineRatio: Float,
)

fun computeScale(values: List<Float>): Scale {
    if (values.isEmpty()) return Scale(0f, 0f, 1f)
    val posMax = values.maxOf { max(it, 0f) }
    val negMin = values.minOf { min(it, 0f) } // <= 0
    val total = (posMax - negMin).let { if (it == 0f) 1f else it }
    val baseline = posMax / total
    return Scale(posMax, negMin, baseline)
}
