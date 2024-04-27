package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoWindModel

@Serializable
data class WeeklyWeatherInfoWind(
    @SerialName("deg")
    val deg: Int? = null,
    @SerialName("gust")
    val gust: Double? = null,
    @SerialName("speed")
    val speed: Double? = null
)

fun WeeklyWeatherInfoWind?.toDomain() = WeeklyWeatherInfoWindModel(
    deg = this?.deg.orZero(),
    gust = this?.gust.orZero(),
    speed = this?.speed.orZero()
)