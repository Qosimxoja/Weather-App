package uz.kosimkhuja.sharipov.domain.remote.current.useCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.kosimkhuja.sharipov.domain.common.FlowUseCase
import uz.kosimkhuja.sharipov.domain.remote.WeatherInfoRemoteDataSource
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherModel
import javax.inject.Inject

interface CurrentWeatherUseCase : FlowUseCase<CurrentWeatherUseCaseParams, CurrentWeatherModel>

class CurrentWeatherUseCaseImpl @Inject constructor(
    private val dataSource: WeatherInfoRemoteDataSource
) : CurrentWeatherUseCase {
    override fun execute(param: CurrentWeatherUseCaseParams): Flow<Result<CurrentWeatherModel>> =
        flow {
            val result = dataSource.getCurrentWeather(
                latitude = param.latitude,
                longitude = param.longitude,
                units = param.units,
                apiKey = param.apiKey
            )

            if (result.code in 200..299) emit(value = Result.success(value = result))
            else emit(value = Result.failure(exception = Throwable(message = result.message.toString())))
        }
}

data class CurrentWeatherUseCaseParams(
    val latitude: String,
    val longitude: String,
    val units: String,
    val apiKey: String
)