package uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.myweatherapp.R
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.actionBar.AppActionBar
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.actionBar.AppActionBarIconType
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.lottie.AppLottieView
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.text.AppText
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.weatherDetails.WeatherDetailsComponent
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.HomeScreenViewType
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.model.CurrencyWeatherUiParams

@Composable
fun HomeCurrentWeatherComponent(
    modifier: Modifier = Modifier,
    params: CurrencyWeatherUiParams?,
    type: HomeScreenViewType
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val cardBackgroundColor = Brush.linearGradient(
        start = Offset(x = screenWidth.value, y = 0f),
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY),
        colors = listOf(
            colorResource(id = R.color.mainGradientStartColor),
            colorResource(id = R.color.mainGradientMiddleColor),
            colorResource(id = R.color.mainGradientEndColor),
        )
    )
    val boxBackgroundColor = Brush.linearGradient(
        start = Offset(x = screenWidth.value, y = 0f),
        end = Offset(x = 0f, y = Float.POSITIVE_INFINITY),
        colors = listOf(
            colorResource(id = R.color.mainGradientStartColor).copy(alpha = 0.5f),
            colorResource(id = R.color.mainGradientMiddleColor).copy(alpha = 0.5f),
            colorResource(id = R.color.mainGradientEndColor).copy(alpha = 0.5f)
        )
    )

    val contentModifier = when (type) {
        HomeScreenViewType.CURRENT -> modifier
        else -> Modifier
    }

    Box(
        modifier = contentModifier
            .background(
                brush = boxBackgroundColor,
                shape = RoundedCornerShape(70.dp)
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .shadow(
                    elevation = 10.dp,
                    ambientColor = colorResource(id = R.color.mainGradientStartColor),
                    spotColor = colorResource(id = R.color.mainGradientStartColor),
                    shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)
                )
                .background(
                    brush = cardBackgroundColor,
                    shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)
                )
                .border(
                    width = 0.5.dp,
                    color = colorResource(id = R.color.white).copy(alpha = 0.3f),
                    shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)
                )
                .padding(all = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppActionBar(
                title = params?.city.orEmpty(),
                iconBeforeTitle = AppActionBarIconType.DrawableIcon(R.drawable.location_icon),
                leadingIcon = AppActionBarIconType.DrawableIcon(R.drawable.menu)
            )

            AnimatedContent(
                targetState = type,
                label = "AnimatedContent"
            ) { target ->
                when (target) {
                    HomeScreenViewType.CURRENT -> {
                        CurrentWeatherInfoComponent(params = params, screenWidth = screenWidth)
                    }

                    HomeScreenViewType.WEEKLY -> {
                        TomorrowWeatherInfoComponent(params = params, screenWidth = screenWidth)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                thickness = 0.5.dp,
                color = colorResource(id = R.color.textPrimary).copy(alpha = 0.2f)
            )

            WeatherDetailsComponent(
                modifier = Modifier.padding(horizontal = 20.dp),
                windSpeed = params?.windSpeed.orEmpty(),
                humidity = params?.humidity.orEmpty(),
                visibility = params?.visibility.orEmpty()
            )
        }
    }
}

@Composable
private fun CurrentWeatherInfoComponent(
    params: CurrencyWeatherUiParams?,
    screenWidth: Dp
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AppLottieView(
            modifier = Modifier.size(size = screenWidth.div(1.5f)),
            resource = params?.icon.orZero()
        )

        Row {
            AppText(
                text = params?.temp.orEmpty(),
                fontSize = 100.sp,
                fontWeight = FontWeight.Black
            )

            AppText(
                text = Constants.DEGREE,
                fontSize = 50.sp,
                opacity = 0.5f
            )
        }

        AppText(
            text = params?.weather.orEmpty(),
            fontSize = 26.sp
        )

        AppText(
            text = params?.date.orEmpty(),
            fontSize = 10.sp,
            fontWeight = FontWeight.Light,
            color = colorResource(id = R.color.white).copy(alpha = 0.2f)
        )
    }
}

@Composable
private fun TomorrowWeatherInfoComponent(
    params: CurrencyWeatherUiParams?,
    screenWidth: Dp
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppLottieView(
            modifier = Modifier.size(size = screenWidth.div(2)),
            resource = params?.icon.orZero()
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                AppText(
                    text = params?.temp.orEmpty(),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Black
                )

                AppText(
                    text = Constants.DEGREE,
                    fontSize = 50.sp,
                    opacity = 0.5f
                )
            }

            AppText(
                text = params?.weather.orEmpty(),
                fontSize = 26.sp
            )

            AppText(
                text = params?.date.orEmpty(),
                fontSize = 10.sp,
                fontWeight = FontWeight.Light,
                color = colorResource(id = R.color.white).copy(alpha = 0.2f)
            )
        }
    }
}