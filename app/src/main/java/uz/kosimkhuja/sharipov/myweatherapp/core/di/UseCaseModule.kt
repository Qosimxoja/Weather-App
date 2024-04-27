package uz.kosimkhuja.sharipov.myweatherapp.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.kosimkhuja.sharipov.domain.remote.current.useCase.CurrentWeatherUseCase
import uz.kosimkhuja.sharipov.domain.remote.current.useCase.CurrentWeatherUseCaseImpl
import uz.kosimkhuja.sharipov.domain.remote.weekly.useCase.WeeklyWeatherInfoUseCase
import uz.kosimkhuja.sharipov.domain.remote.weekly.useCase.WeeklyWeatherInfoUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindCurrentWeatherUseCase(impl: CurrentWeatherUseCaseImpl): CurrentWeatherUseCase

    @Binds
    fun bindWeeklyWeatherInfoUseCase(impl: WeeklyWeatherInfoUseCaseImpl): WeeklyWeatherInfoUseCase

}