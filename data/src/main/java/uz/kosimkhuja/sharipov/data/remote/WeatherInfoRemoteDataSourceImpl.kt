package uz.kosimkhuja.sharipov.data.remote

import uz.kosimkhuja.sharipov.data.remote.current.toDomain
import uz.kosimkhuja.sharipov.data.remote.weekly.toDomain
import uz.kosimkhuja.sharipov.domain.remote.WeatherInfoRemoteDataSource
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherModel
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoModel
import javax.inject.Inject

class WeatherInfoRemoteDataSourceImpl @Inject constructor(
    private val api: WeatherAPI
) : WeatherInfoRemoteDataSource {

    override suspend fun getCurrentWeather(
        latitude: String,
        longitude: String,
        units: String,
        apiKey: String
    ): CurrentWeatherModel = api.getCurrentWeather(
        latitude = latitude,
        longitude = longitude,
        units = units,
        apiKey = apiKey
    ).toDomain()

    override suspend fun getWeeklyWeather(
        latitude: String,
        longitude: String,
        units: String,
        apiKey: String
    ): WeeklyWeatherInfoModel = api.getWeeklyWeather(
        latitude = latitude,
        longitude = longitude,
        units = units,
        apiKey = apiKey
    ).toDomain()


}