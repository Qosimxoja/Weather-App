package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoSysModel

@Serializable
data class WeeklyWeatherInfoSys(
    @SerialName("pod")
    val pod: String? = null
)

fun WeeklyWeatherInfoSys?.toDomain() = WeeklyWeatherInfoSysModel(
    pod = this?.pod.orEmpty()
)