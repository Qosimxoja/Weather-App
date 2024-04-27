package uz.kosimkhuja.sharipov.data.remote.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherCoordModel

@Serializable
data class CurrentWeatherCoord(
    @SerialName("lat")
    val lat: Double? = null,
    @SerialName("lon")
    val lon: Double? = null
)

fun CurrentWeatherCoord?.toDomain() = CurrentWeatherCoordModel(
    lat = this?.lat.orZero(),
    lon = this?.lon.orZero()
)