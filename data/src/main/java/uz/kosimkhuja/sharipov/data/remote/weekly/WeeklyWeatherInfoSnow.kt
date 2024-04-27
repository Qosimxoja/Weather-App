package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoSnowModel

@Serializable
data class WeeklyWeatherInfoSnow(
    @SerialName("3h")
    val h: Double? = null
)

fun WeeklyWeatherInfoSnow?.toDomain() = WeeklyWeatherInfoSnowModel(
    h = this?.h.orZero()
)