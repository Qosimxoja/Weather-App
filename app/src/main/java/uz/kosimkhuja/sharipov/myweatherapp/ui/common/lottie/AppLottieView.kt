package uz.kosimkhuja.sharipov.myweatherapp.ui.common.lottie

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AppLottieView(
    modifier: Modifier,
    @RawRes resource: Int,
    speed: Float = 1.0f,
    contentScale: ContentScale = ContentScale.Fit
) {
    val preloaderLottieComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId = resource)
    )

    val preloaderProgress by animateLottieCompositionAsState(
        composition = preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        speed = speed
    )


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = { preloaderProgress },
        modifier = modifier,
        contentScale = contentScale
    )
}