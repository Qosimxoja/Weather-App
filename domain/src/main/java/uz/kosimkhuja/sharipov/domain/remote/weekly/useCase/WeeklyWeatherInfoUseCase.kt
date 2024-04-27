package uz.kosimkhuja.sharipov.domain.remote.weekly.useCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.kosimkhuja.sharipov.domain.common.FlowUseCase
import uz.kosimkhuja.sharipov.domain.remote.WeatherInfoRemoteDataSource
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoModel
import javax.inject.Inject

interface WeeklyWeatherInfoUseCase :
    FlowUseCase<WeeklyWeatherInfoUseCaseParams, WeeklyWeatherInfoModel>

class WeeklyWeatherInfoUseCaseImpl @Inject constructor(
    private val dataSource: WeatherInfoRemoteDataSource
) : WeeklyWeatherInfoUseCase {
    override fun execute(param: WeeklyWeatherInfoUseCaseParams): Flow<Result<WeeklyWeatherInfoModel>> =
        flow {
            val result = dataSource.getWeeklyWeather(
                latitude = param.latitude,
                longitude = param.longitude,
                units = param.units,
                apiKey = param.apiKey
            )

            if (result.code in 200..299) emit(value = Result.success(value = result))
            else emit(value = Result.failure(exception = Throwable(message = result.message.toString())))
        }
}

data class WeeklyWeatherInfoUseCaseParams(
    val latitude: String,
    val longitude: String,
    val units: String,
    val apiKey: String
)