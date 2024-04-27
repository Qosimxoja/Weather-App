package uz.kosimkhuja.sharipov.data.remote.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.File
import java.util.concurrent.TimeUnit

object Network {

    private const val CONTENT_TYPE = "application/json"

    val okHttpCache: Cache
        get() {
            val cacheDirectory = File("http-cache.tmp")
            val cacheSize = 50 * 1024 * 1024
            return Cache(cacheDirectory, cacheSize.toLong())
        }

    val appJson: Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    fun getJsonFactory(json: Json): Converter.Factory =
        json.asConverterFactory(contentType = CONTENT_TYPE.toMediaType())

    fun getLoggingInterceptor(
        isDebugEnvironment: Boolean
    ): HttpLoggingInterceptor? = if (isDebugEnvironment)
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    else null

    fun getChuckerInterceptor(context: Context) = ChuckerInterceptor.Builder(context).build()

    fun getOkHttpClient(
        cache: Cache,
        loggingInterceptor: HttpLoggingInterceptor?,
        chuckerInterceptor: ChuckerInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder().apply {
            retryOnConnectionFailure(false)

            connectTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)

            cache(cache)

            loggingInterceptor?.let {
                addInterceptor(loggingInterceptor)
            }
            addInterceptor(chuckerInterceptor)
        }.build()

    fun getRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()

    inline fun <reified T> getApi(retrofit: Retrofit): T = retrofit.create(T::class.java)

}