package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoRainModel

@Serializable
data class WeeklyWeatherInfoRain(
    @SerialName("3h")
    val h: Double? = null
)

fun WeeklyWeatherInfoRain?.toDomain() = WeeklyWeatherInfoRainModel(
    h = this?.h.orZero()
)