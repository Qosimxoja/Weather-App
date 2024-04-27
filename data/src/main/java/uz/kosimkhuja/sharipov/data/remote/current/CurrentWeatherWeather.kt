package uz.kosimkhuja.sharipov.data.remote.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherWeatherModel

@Serializable
data class CurrentWeatherWeather(
    @SerialName("description")
    val description: String? = null,
    @SerialName("icon")
    val icon: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("main")
    val main: String? = null
)

fun CurrentWeatherWeather?.toDomain() = CurrentWeatherWeatherModel(
    description = this?.description.orEmpty(),
    icon = this?.icon.orEmpty(),
    id = this?.id.orZero(),
    main = this?.main.orEmpty()
)