package uz.kosimkhuja.sharipov.data.remote.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherSysModel

@Serializable
data class CurrentWeatherSys(
    @SerialName("country")
    val country: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("sunrise")
    val sunrise: Int? = null,
    @SerialName("sunset")
    val sunset: Int? = null,
    @SerialName("type")
    val type: Int? = null
)

fun CurrentWeatherSys?.toDomain() = CurrentWeatherSysModel(
    country = this?.country.orEmpty(),
    id = this?.id.orZero(),
    sunrise = this?.sunrise.orZero(),
    sunset = this?.sunset.orZero(),
    type = this?.type.orZero()
)