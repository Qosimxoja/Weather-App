package uz.kosimkhuja.sharipov.myweatherapp.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.kosimkhuja.sharipov.data.remote.WeatherInfoRemoteDataSourceImpl
import uz.kosimkhuja.sharipov.domain.remote.WeatherInfoRemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataSourceModule {

    @Binds
    fun bindWeatherInfoDataSource(impl: WeatherInfoRemoteDataSourceImpl): WeatherInfoRemoteDataSource

}