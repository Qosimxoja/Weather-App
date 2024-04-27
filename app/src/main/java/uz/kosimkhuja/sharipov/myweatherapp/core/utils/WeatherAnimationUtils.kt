package uz.kosimkhuja.sharipov.myweatherapp.core.utils

import androidx.annotation.RawRes
import uz.kosimkhuja.sharipov.myweatherapp.R
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants

class WeatherAnimationUtils {

    enum class WeatherIcons(val code: String, @RawRes val icon: Int) {
        CLEAR_DAY(code = "01d", icon = R.raw.sun_animation),
        CLEAR_NIGHT(code = "01n", icon = R.raw.moon_animation),
        CLEAR_CLOUD_DAY(code = "02d", icon = R.raw.sun_with_cloud_animation),
        CLEAR_CLOUD_NIGHT(code = "02n", icon = R.raw.moon_with_cloud_animation),
        CLOUD_DAY(code = "03d", icon = R.raw.cloud_animation),
        CLOUD_NIGHT(code = "03n", icon = R.raw.cloud_animation),
        BROKEN_CLOUD_DAY(code = "04d", icon = R.raw.cloud_animation),
        BROKEN_CLOUD_NIGHT(code = "04n", icon = R.raw.cloud_animation),
        SHOWER_RAIN_DAY(code = "09d", icon = R.raw.sun_with_rain_animation),
        SHOWER_RAIN_NIGHT(code = "09n", icon = R.raw.moon_with_rain_animation),
        LIGHT_RAIN_DAY(code = "10d", icon = R.raw.sun_with_rain_animation),
        LIGHT_RAIN_NIGHT(code = "10n", icon = R.raw.moon_with_rain_animation),
        STORM_DAY(code = "11d", icon = R.raw.thunderstorm_animation),
        STORM_NIGHT(code = "11n", icon = R.raw.thunderstorm_animation),
        SNOW_DAY(code = "13d", icon = R.raw.snow_animation),
        SNOW_NIGHT(code = "13n", icon = R.raw.snow_animation),
        MIST_DAY(code = "50d", icon = R.raw.mist_animation),
        MISTY_NIGHT(code = "50n", icon = R.raw.mist_animation),
    }

    @RawRes
    fun providerRawAnimationResource(code: String): Int {
        return WeatherIcons.entries.toList().firstOrNull { it.code == code }?.icon ?: R.raw.sun_loading_animation
    }

}