package uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.components

import android.os.Parcelable
import androidx.annotation.RawRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.parcelize.Parcelize
import uz.kosimkhuja.sharipov.myweatherapp.R
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.lottie.AppLottieView
import uz.kosimkhuja.sharipov.myweatherapp.ui.common.text.AppText

@Parcelize
data class HomeWeatherByHoursViewParams(
    val time: String,
    val simpleDate: String,
    @RawRes val icon: Int,
    val temp: String,
    val weather: String
) : Parcelable

@Composable
fun HomeWeatherByHoursView(
    modifier: Modifier = Modifier,
    listOfParams: List<HomeWeatherByHoursViewParams>
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(all = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(listOfParams) { param ->
            Column(
                modifier = Modifier
                    .shadow(
                        elevation = 10.dp,
                        ambientColor = colorResource(id = R.color.white),
                        spotColor = colorResource(id = R.color.white).copy(alpha = 0.1f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .background(
                        color = colorResource(id = R.color.background),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .border(
                        width = 0.5.dp,
                        color = colorResource(id = R.color.white).copy(alpha = 0.2f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(vertical = 5.dp, horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                AppText(text = param.temp, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

                AppLottieView(
                    modifier = Modifier.size(width = 35.dp, height = 30.dp),
                    resource = param.icon,
                    contentScale = ContentScale.Crop
                )

                AppText(
                    text = param.time,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.white).copy(alpha = 0.5f)
                )
            }
        }
    }
}