package uz.kosimkhuja.sharipov.domain.remote.current.model

data class CurrentWeatherSysModel(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)