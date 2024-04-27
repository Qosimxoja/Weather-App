package uz.kosimkhuja.sharipov.domain.remote.weekly.model

data class WeeklyWeatherInfoWeatherModel(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)