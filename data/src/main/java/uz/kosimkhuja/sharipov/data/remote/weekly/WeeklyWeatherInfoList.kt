package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoListModel

@Serializable
data class WeeklyWeatherInfoList(
    @SerialName("clouds")
    val clouds: WeeklyWeatherInfoClouds? = null,
    @SerialName("dt")
    val dt: Int? = null,
    @SerialName("dt_txt")
    val dtTxt: String? = null,
    @SerialName("main")
    val main: WeeklyWeatherInfoMain? = null,
    @SerialName("pop")
    val pop: Double? = null,
    @SerialName("rain")
    val rain: WeeklyWeatherInfoRain? = null,
    @SerialName("snow")
    val snow: WeeklyWeatherInfoSnow? = null,
    @SerialName("sys")
    val sys: WeeklyWeatherInfoSys? = null,
    @SerialName("visibility")
    val visibility: Int? = null,
    @SerialName("weather")
    val weather: List<WeeklyWeatherInfoWeather?>? = null,
    @SerialName("wind")
    val wind: WeeklyWeatherInfoWind? = null
)

fun WeeklyWeatherInfoList?.toDomain() = WeeklyWeatherInfoListModel(
    clouds = this?.clouds.toDomain(),
    dt = this?.dt.orZero(),
    dtTxt = this?.dtTxt.orEmpty(),
    main = this?.main.toDomain(),
    pop = this?.pop.orZero(),
    rain = this?.rain.toDomain(),
    snow = this?.snow.toDomain(),
    sys = this?.sys.toDomain(),
    visibility = this?.visibility.orZero(),
    weather = this?.weather.orEmpty().map { it.toDomain() },
    wind = this?.wind.toDomain()
)