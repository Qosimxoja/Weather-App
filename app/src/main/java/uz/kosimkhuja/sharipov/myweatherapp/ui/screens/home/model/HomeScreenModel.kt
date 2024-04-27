package uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.model

import android.os.Parcelable
import androidx.annotation.RawRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyWeatherUiParams(
    @RawRes val icon: Int,
    val city: String,
    val temp: String,
    val feelsLike: String,
    val weather: String,
    val tempMax: String,
    val tempMin: String,
    val date: String,
    val windSpeed: String,
    val humidity: String,
    val visibility: String
) : Parcelable