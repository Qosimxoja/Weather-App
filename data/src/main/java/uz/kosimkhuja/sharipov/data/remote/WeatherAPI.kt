package uz.kosimkhuja.sharipov.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import uz.kosimkhuja.sharipov.data.remote.current.CurrentWeatherResponse
import uz.kosimkhuja.sharipov.data.remote.weekly.WeeklyWeatherInfoResponse

interface WeatherAPI {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("units") units: String,
        @Query("appid") apiKey: String
    ): CurrentWeatherResponse

    @GET("forecast")
    suspend fun getWeeklyWeather(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("units") units: String,
        @Query("appid") apiKey: String
    ): WeeklyWeatherInfoResponse

}