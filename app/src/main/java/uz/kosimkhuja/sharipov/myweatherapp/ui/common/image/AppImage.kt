package uz.kosimkhuja.sharipov.myweatherapp.ui.common.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    image: AppImageType,
    colorFilter: ColorFilter? = null,
    contentScale: ContentScale = ContentScale.Fit
) {
    val imageDescription = "imageDescription"

    when (image) {
        is AppImageType.DrawableIcon -> {
            Image(
                modifier = modifier,
                painter = painterResource(id = image.iconId),
                contentDescription = imageDescription,
                colorFilter = colorFilter,
                contentScale = contentScale
            )
        }

        is AppImageType.AsyncImage -> {
            AsyncImage(
                modifier = modifier,
                model = image.imageUrl,
                contentDescription = imageDescription,
                colorFilter = colorFilter,
                contentScale = contentScale
            )
        }
    }
}

sealed class AppImageType {
    data class DrawableIcon(@DrawableRes val iconId: Int) : AppImageType()

    data class AsyncImage(val imageUrl: String) : AppImageType()
}