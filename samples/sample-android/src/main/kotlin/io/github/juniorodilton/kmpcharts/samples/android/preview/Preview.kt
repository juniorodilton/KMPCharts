package io.github.juniorodilton.kmpcharts.samples.android.preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import io.github.juniorodilton.kmpcharts.samples.common.ShowcaseApp
import io.github.juniorodilton.kmpcharts.samples.common.preview.sampleBarSeriesBasic

class BarSeriesPreviewProvider : PreviewParameterProvider<List<Pair<String, Float>>> {
    override val values: Sequence<List<Pair<String, Float>>>
        get() = sequenceOf(
            sampleBarSeriesBasic(),
        )
}

@Preview(showBackground = true)
@Composable
private fun Preview(
    @PreviewParameter(BarSeriesPreviewProvider::class) values: List<Pair<String, Float>>
) {
    MaterialTheme {
        ShowcaseApp()
    }
}