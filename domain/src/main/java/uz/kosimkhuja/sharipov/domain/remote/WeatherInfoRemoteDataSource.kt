package uz.kosimkhuja.sharipov.domain.remote

import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherModel
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoModel

interface WeatherInfoRemoteDataSource {

    suspend fun getCurrentWeather(
        latitude: String,
        longitude: String,
        units: String,
        apiKey: String
    ): CurrentWeatherModel

    suspend fun getWeeklyWeather(
        latitude: String,
        longitude: String,
        units: String,
        apiKey: String
    ): WeeklyWeatherInfoModel

}