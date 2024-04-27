package uz.kosimkhuja.sharipov.domain.remote.current.model

data class CurrentWeatherMainModel(
    val feelsLike: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
)