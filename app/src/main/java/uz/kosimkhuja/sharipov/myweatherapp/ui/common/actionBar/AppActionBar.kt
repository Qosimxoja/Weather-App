package uz.kosimkhuja.sharipov.myweatherapp.ui.common.actionBar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.image.AppImage
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.image.AppImageType
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.text.AppText

@Composable
fun AppActionBar(
    modifier: Modifier = Modifier,
    title: String,
    iconBeforeTitle: AppActionBarIconType = AppActionBarIconType.None,
    leadingIcon: AppActionBarIconType = AppActionBarIconType.None,
    trailingIcon: AppActionBarIconType = AppActionBarIconType.None
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(30.dp)) {
            leadingIcon.convertToAppImage()?.let { leadingIcon ->
                AppImage(modifier = Modifier.fillMaxSize(), image = leadingIcon)
            }
        }

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            iconBeforeTitle.convertToAppImage()?.let { iconBeforeTitle ->
                AppImage(
                    image = iconBeforeTitle,
                    contentScale = ContentScale.Inside
                )
            }

            AppText(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Box(modifier = Modifier.size(30.dp)) {
            trailingIcon.convertToAppImage()?.let { trailingIcon ->
                AppImage(
                    modifier = Modifier.fillMaxSize(),
                    image = trailingIcon,
                    contentScale = ContentScale.Inside
                )
            }
        }
    }
}

private fun AppActionBarIconType.convertToAppImage(): AppImageType? {
    return when (this) {
        is AppActionBarIconType.DrawableIcon -> AppImageType.DrawableIcon(this.iconId)

        is AppActionBarIconType.AsyncImage -> AppImageType.AsyncImage(this.imageUrl)

        is AppActionBarIconType.None -> null
    }
}

sealed class AppActionBarIconType {
    data class DrawableIcon(@DrawableRes val iconId: Int) : AppActionBarIconType()

    data class AsyncImage(val imageUrl: String) : AppActionBarIconType()

    data object None : AppActionBarIconType()
}