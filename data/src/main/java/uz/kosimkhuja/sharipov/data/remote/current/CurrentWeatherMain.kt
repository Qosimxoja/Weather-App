package uz.kosimkhuja.sharipov.data.remote.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherMainModel

@Serializable
data class CurrentWeatherMain(
    @SerialName("feels_like")
    val feelsLike: Double? = null,
    @SerialName("humidity")
    val humidity: Int? = null,
    @SerialName("pressure")
    val pressure: Int? = null,
    @SerialName("temp")
    val temp: Double? = null,
    @SerialName("temp_max")
    val tempMax: Double? = null,
    @SerialName("temp_min")
    val tempMin: Double? = null
)

fun CurrentWeatherMain?.toDomain() = CurrentWeatherMainModel(
    feelsLike = this?.feelsLike.orZero(),
    humidity = this?.humidity.orZero(),
    pressure = this?.pressure.orZero(),
    temp = this?.temp.orZero(),
    tempMax = this?.tempMax.orZero(),
    tempMin = this?.tempMin.orZero()
)