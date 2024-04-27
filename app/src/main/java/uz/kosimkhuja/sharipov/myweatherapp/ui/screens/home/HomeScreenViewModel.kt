package uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.kosimkhuja.sharipov.domain.remote.current.useCase.CurrentWeatherUseCase
import uz.kosimkhuja.sharipov.domain.remote.current.useCase.CurrentWeatherUseCaseParams
import uz.kosimkhuja.sharipov.domain.remote.weekly.useCase.WeeklyWeatherInfoUseCase
import uz.kosimkhuja.sharipov.domain.remote.weekly.useCase.WeeklyWeatherInfoUseCaseParams
import uz.kosimkhuja.sharipov.myweatherapp.BuildConfig
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants.DATE_SIMPLE_FORMAT_PATTERN
import uz.kosimkhuja.sharipov.myweatherapp.core.utils.DateUtils
import uz.kosimkhuja.sharipov.myweatherapp.core.utils.ResUtil
import uz.kosimkhuja.sharipov.myweatherapp.ui.base.BaseViewModel
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.convertor.toUiModel
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.components.HomeWeatherByHoursViewParams
import uz.kosimkhuja.sharipov.myweatherapp.ui.screens.home.model.CurrencyWeatherUiParams
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val currentWeatherUseCase: CurrentWeatherUseCase,
    private val weeklyWeatherUseCase: WeeklyWeatherInfoUseCase,
    private val resUtil: ResUtil,
    private val dateUtils: DateUtils
) : BaseViewModel() {

    private val _currentWeather = MutableStateFlow<CurrencyWeatherUiParams?>(null)
    val currentWeather: StateFlow<CurrencyWeatherUiParams?> = _currentWeather

    private val _hourlyWeather = MutableStateFlow<List<HomeWeatherByHoursViewParams>>(emptyList())
    val hourlyWeather: StateFlow<List<HomeWeatherByHoursViewParams>> = _hourlyWeather

    private val _weeklyWeather = MutableStateFlow<List<HomeWeatherByHoursViewParams>>(emptyList())
    val weeklyWeather: StateFlow<List<HomeWeatherByHoursViewParams>> = _weeklyWeather

    private val _viewType = MutableStateFlow<HomeScreenViewType>(HomeScreenViewType.CURRENT)
    val viewType: StateFlow<HomeScreenViewType> = _viewType

    private val _currentDate = MutableStateFlow("")

    fun getWeatherInfo() {
        if (_currentWeather.value == null)
            getCurrentWeather()
        else if (_weeklyWeather.value.isEmpty())
            getWeeklyWeather()
    }

    fun changeViewType() {
        _viewType.value =
            if (_viewType.value == HomeScreenViewType.CURRENT) HomeScreenViewType.WEEKLY
            else HomeScreenViewType.CURRENT
    }

    private fun getCurrentWeather() {
        viewModelScope.launch {
            setLoading(loading = true)

            currentWeatherUseCase(
                param = CurrentWeatherUseCaseParams(
                    latitude = "41.311151",
                    longitude = "69.279737",
                    units = "metric",
                    apiKey = BuildConfig.API_KEY
                )
            ).collect { result ->
                result.onSuccess {
                    _currentWeather.value = it.toUiModel(resUtil = resUtil, dateUtils = dateUtils)
                    _currentDate.value =
                        dateUtils.longToString(date = it.dt, DATE_SIMPLE_FORMAT_PATTERN)

                    getWeeklyWeather()
                }.onFailure {
                    setError(throwable = it)
                }
            }
        }
    }

    private fun getWeeklyWeather() {
        viewModelScope.launch {

            weeklyWeatherUseCase(
                param = WeeklyWeatherInfoUseCaseParams(
                    latitude = "41.311151",
                    longitude = "69.279737",
                    units = "metric",
                    apiKey = BuildConfig.API_KEY
                )
            ).collect { result ->
                result.onSuccess {
                    val model = it.toUiModel(resUtil = resUtil, dateUtils = dateUtils)
                    _weeklyWeather.value = model
                    _hourlyWeather.value =
                        model.filter { param -> param.simpleDate == _currentDate.value }

                    setLoading(loading = false)
                }.onFailure {
                    setError(throwable = it)
                }
            }
        }
    }

}