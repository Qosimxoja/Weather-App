package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoCloudsModel

@Serializable
data class WeeklyWeatherInfoClouds(
    @SerialName("all")
    val all: Int? = null
)

fun WeeklyWeatherInfoClouds?.toDomain() = WeeklyWeatherInfoCloudsModel(
    all = this?.all.orZero()
)