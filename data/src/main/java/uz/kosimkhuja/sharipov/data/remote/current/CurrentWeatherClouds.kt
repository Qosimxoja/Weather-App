package uz.kosimkhuja.sharipov.data.remote.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherCloudsModel

@Serializable
data class CurrentWeatherClouds(
    @SerialName("all")
    val all: Int? = null
)

fun CurrentWeatherClouds?.toDomain() = CurrentWeatherCloudsModel(
    all = this?.all.orZero()
)