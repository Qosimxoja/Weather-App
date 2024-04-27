package uz.kosimkhuja.sharipov.myweatherapp.ui.screens.convertor

import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.current.model.CurrentWeatherModel
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoModel
import uz.kosimkhuja.sharipov.myweatherapp.R
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants.PERCENT
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants.VISIBILITY_UNIT
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants.WIND_UNIT
import uz.kosimkhuja.sharipov.myweatherapp.core.utils.DateUtils
import uz.kosimkhuja.sharipov.myweatherapp.core.utils.ResUtil
import uz.kosimkhuja.sharipov.myweatherapp.core.utils.WeatherAnimationUtils
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.components.HomeWeatherByHoursViewParams
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.model.CurrencyWeatherUiParams
import kotlin.math.roundToInt

fun CurrentWeatherModel?.toUiModel(resUtil: ResUtil, dateUtils: DateUtils) =
    CurrencyWeatherUiParams(
        icon = WeatherAnimationUtils()
            .providerRawAnimationResource(code = this?.weather?.firstOrNull()?.icon.orEmpty()),
        city = this?.name.orEmpty(),
        temp = this?.main?.temp.orZero().roundToInt().toString(),
        feelsLike = resUtil.getString(
            id = R.string.degree,
            vararg = this?.main?.feelsLike.orZero().roundToInt()
        ),
        weather = this?.weather?.firstOrNull()?.main.orEmpty(),
        tempMax = resUtil.getString(
            id = R.string.degree,
            vararg = this?.main?.tempMax.orZero().roundToInt()
        ),
        tempMin = resUtil.getString(
            id = R.string.degree,
            vararg = this?.main?.tempMin.orZero().roundToInt()
        ),
        date = dateUtils.longToString(this?.dt.orZero()),
        windSpeed = "${this?.wind?.speed.orZero()} $WIND_UNIT",
        humidity = "${this?.main?.humidity.orZero()} $PERCENT",
        visibility = "${this?.visibility?.takeIf { it < 10 } ?: 10} $VISIBILITY_UNIT "
    )

fun WeeklyWeatherInfoModel?.toUiModel(resUtil: ResUtil, dateUtils: DateUtils) =
    this?.list.orEmpty().map {
        HomeWeatherByHoursViewParams(
            time = dateUtils.formatRemoteDate(
                date = it.dtTxt,
                fromPattern = Constants.REMOTE_DATE_PATTERN,
                toPattern = Constants.ONLY_HOUR_DATE_PATTERN
            ),
            simpleDate = dateUtils.formatRemoteDate(
                date = it.dtTxt,
                fromPattern = Constants.REMOTE_DATE_PATTERN,
                toPattern = Constants.DATE_SIMPLE_FORMAT_PATTERN
            ),
            icon = WeatherAnimationUtils().providerRawAnimationResource(it.weather.firstOrNull()?.icon.orEmpty()),
            temp = resUtil.getString(id = R.string.degree, vararg = it.main.temp.roundToInt()),
            weather = it.weather.firstOrNull()?.main.orEmpty()
        )
    }