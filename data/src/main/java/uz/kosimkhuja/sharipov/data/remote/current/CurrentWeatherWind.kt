package uz.kosimkhuja.sharipov.data.remote.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherWindModel

@Serializable
data class CurrentWeatherWind(
    @SerialName("deg")
    val deg: Int? = null,
    @SerialName("speed")
    val speed: Double? = null
)

fun CurrentWeatherWind?.toDomain() = CurrentWeatherWindModel(
    deg = this?.deg.orZero(),
    speed = this?.speed.orZero()
)