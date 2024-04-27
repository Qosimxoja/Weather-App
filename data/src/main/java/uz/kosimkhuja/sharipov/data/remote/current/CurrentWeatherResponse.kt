package uz.kosimkhuja.sharipov.data.remote.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.base.BaseResponse
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherModel

@Serializable
data class CurrentWeatherResponse(
    @SerialName("base")
    val base: String? = null,
    @SerialName("clouds")
    val clouds: CurrentWeatherClouds? = null,
    @SerialName("coord")
    val coord: CurrentWeatherCoord? = null,
    @SerialName("dt")
    val dt: Long? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("main")
    val main: CurrentWeatherMain? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("sys")
    val sys: CurrentWeatherSys? = null,
    @SerialName("timezone")
    val timezone: Int? = null,
    @SerialName("visibility")
    val visibility: Int? = null,
    @SerialName("weather")
    val weather: List<CurrentWeatherWeather?>? = null,
    @SerialName("wind")
    val wind: CurrentWeatherWind? = null
) : BaseResponse()

fun CurrentWeatherResponse?.toDomain() = CurrentWeatherModel(
    base = this?.base.orEmpty(),
    clouds = this?.clouds.toDomain(),
    coord = this?.coord.toDomain(),
    dt = this?.dt.orZero(),
    id = this?.id.orZero(),
    main = this?.main.toDomain(),
    name = this?.name.orEmpty(),
    sys = this?.sys.toDomain(),
    timezone = this?.timezone.orZero(),
    visibility = this?.visibility.orZero(),
    weather = this?.weather.orEmpty().map { it.toDomain() },
    wind = this?.wind.toDomain()
).apply {
    code = this@toDomain?.code.orZero()
    message = this@toDomain?.message.orZero()
}