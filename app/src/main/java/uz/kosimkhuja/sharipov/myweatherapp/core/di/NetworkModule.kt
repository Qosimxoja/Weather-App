package uz.kosimkhuja.sharipov.myweatherapp.core.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import uz.kosimkhuja.sharipov.data.remote.WeatherAPI
import uz.kosimkhuja.sharipov.data.remote.network.Network
import uz.kosimkhuja.sharipov.myweatherapp.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideDebugEnvironment(): Boolean = BuildConfig.DEBUG

    @Provides
    fun provideOkHttpCache(): Cache = Network.okHttpCache

    @Provides
    fun provideJson(): Json = Network.appJson

    @Provides
    fun provideJsonFactory(json: Json): Converter.Factory = Network.getJsonFactory(json = json)

    @Provides
    fun provideHttpLogginInterceptor(provideDebugEnvironment: Boolean): HttpLoggingInterceptor? =
        Network.getLoggingInterceptor(isDebugEnvironment = provideDebugEnvironment)

    @Provides
    fun provideChuckerInterceptor(@ApplicationContext context: Context) =
        Network.getChuckerInterceptor(context = context)

    @Provides
    fun provideOkHttpClient(
        cache: Cache,
        loggingInterceptor: HttpLoggingInterceptor?,
        chuckerInterceptor: ChuckerInterceptor
    ): OkHttpClient = Network.getOkHttpClient(
        cache = cache,
        loggingInterceptor = loggingInterceptor,
        chuckerInterceptor = chuckerInterceptor
    )

    @Provides
    fun provideRetrofit(client: OkHttpClient, factory: Converter.Factory): Retrofit =
        Network.getRetrofit(
            baseUrl = BuildConfig.BASE_URL,
            okHttpClient = client,
            converterFactory = factory
        )

    @Provides
    fun provideWeatherApi(retrofit: Retrofit) = Network.getApi<WeatherAPI>(retrofit = retrofit)

}