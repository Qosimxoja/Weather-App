package uz.kosimkhuja.sharipov.myweatherapp.ui.common.weatherDetails

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.kosimkhuja.sharipov.myweatherapp.R
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.text.AppText

private data class WeatherDetailsComponentParams(
    @DrawableRes val icon: Int,
    val value: String,
    val text: String
)

@Composable
fun WeatherDetailsComponent(
    modifier: Modifier = Modifier,
    windSpeed: String,
    humidity: String,
    visibility: String
) {
    val listOfParams = listOf(
        WeatherDetailsComponentParams(
            icon = R.drawable.wind,
            value = windSpeed,
            text = stringResource(R.string.wind)
        ),
        WeatherDetailsComponentParams(
            icon = R.drawable.humidity,
            value = humidity,
            text = stringResource(R.string.humidity)
        ),
        WeatherDetailsComponentParams(
            icon = R.drawable.visibility,
            value = visibility,
            text = stringResource(R.string.visibility)
        )
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        listOfParams.map { param ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = param.icon),
                    contentDescription = param.text
                )

                AppText(text = param.value)

                AppText(
                    text = param.text,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.white).copy(alpha = 0.5f)
                )
            }
        }
    }
}