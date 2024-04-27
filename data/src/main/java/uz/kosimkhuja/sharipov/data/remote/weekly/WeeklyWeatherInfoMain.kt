package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoMainModel

@Serializable
data class WeeklyWeatherInfoMain(
    @SerialName("feels_like")
    val feelsLike: Double? = null,
    @SerialName("grnd_level")
    val grndLevel: Int? = null,
    @SerialName("humidity")
    val humidity: Int? = null,
    @SerialName("pressure")
    val pressure: Int? = null,
    @SerialName("sea_level")
    val seaLevel: Int? = null,
    @SerialName("temp")
    val temp: Double? = null,
    @SerialName("temp_kf")
    val tempKf: Double? = null,
    @SerialName("temp_max")
    val tempMax: Double? = null,
    @SerialName("temp_min")
    val tempMin: Double? = null
)

fun WeeklyWeatherInfoMain?.toDomain() = WeeklyWeatherInfoMainModel(
    feelsLike = this?.feelsLike.orZero(),
    grndLevel = this?.grndLevel.orZero(),
    humidity = this?.humidity.orZero(),
    pressure = this?.pressure.orZero(),
    seaLevel = this?.seaLevel.orZero(),
    temp = this?.temp.orZero(),
    tempKf = this?.tempKf.orZero(),
    tempMax = this?.tempMax.orZero(),
    tempMin = this?.tempMin.orZero()
)