package io.github.juniorodilton.kmpcharts.samples.common.preview

fun sampleBarSeriesBasic(): List<Pair<String, Float>> {
    return (1..6)
        .map {
            Pair(it.toString(), it.toFloat())
        }
        .toList()
}