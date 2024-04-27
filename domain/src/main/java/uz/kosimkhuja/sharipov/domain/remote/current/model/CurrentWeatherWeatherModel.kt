package uz.kosimkhuja.sharipov.domain.remote.current.model

data class CurrentWeatherWeatherModel(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)