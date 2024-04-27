package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoCoordModel

@Serializable
data class WeeklyWeatherInfoCoord(
    @SerialName("lat")
    val lat: Double? = null,
    @SerialName("lon")
    val lon: Double? = null
)

fun WeeklyWeatherInfoCoord?.toDomain() = WeeklyWeatherInfoCoordModel(
    lat = this?.lat.orZero(),
    lon = this?.lon.orZero()
)