package uz.kosimkhuja.sharipov.domain.remote.weekly.model

data class WeeklyWeatherInfoCityModel(
    val coord: WeeklyWeatherInfoCoordModel,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)