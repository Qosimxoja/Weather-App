package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoCityModel

@Serializable
data class WeeklyWeatherInfoCity(
    @SerialName("coord")
    val coord: WeeklyWeatherInfoCoord? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("population")
    val population: Int? = null,
    @SerialName("sunrise")
    val sunrise: Int? = null,
    @SerialName("sunset")
    val sunset: Int? = null,
    @SerialName("timezone")
    val timezone: Int? = null
)

fun WeeklyWeatherInfoCity?.toDomain() = WeeklyWeatherInfoCityModel(
    coord = this?.coord.toDomain(),
    country = this?.country.orEmpty(),
    id = this?.id.orZero(),
    name = this?.name.orEmpty(),
    population = this?.population.orZero(),
    sunrise = this?.sunrise.orZero(),
    sunset = this?.sunset.orZero(),
    timezone = this?.timezone.orZero()
)