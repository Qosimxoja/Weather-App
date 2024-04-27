package uz.kosimkhuja.sharipov.myweatherapp.ui.common.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.kosimkhuja.sharipov.myweatherapp.R
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.lottie.AppLottieView

@Composable
fun AppLoadingView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background)),
        contentAlignment = Alignment.Center
    ) {
        AppLottieView(
            modifier = Modifier.size(150.dp),
            resource = R.raw.sun_loading_animation
        )
    }
}

@Preview
@Composable
private fun AppLoadingPreview() {
    AppLoadingView()
}