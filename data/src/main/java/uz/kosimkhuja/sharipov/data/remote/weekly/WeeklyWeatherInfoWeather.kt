package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoWeatherModel

@Serializable
data class WeeklyWeatherInfoWeather(
    @SerialName("description")
    val description: String? = null,
    @SerialName("icon")
    val icon: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("main")
    val main: String? = null
)

fun WeeklyWeatherInfoWeather?.toDomain() = WeeklyWeatherInfoWeatherModel(
    description = this?.description.orEmpty(),
    icon = this?.icon.orEmpty(),
    id = this?.id.orZero(),
    main = this?.main.orEmpty()
)