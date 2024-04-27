package uz.kosimkhuja.sharipov.domain.remote.current.model

import uz.kosimkhuja.sharipov.domain.base.BaseDataModel

data class CurrentWeatherModel(
    val base: String,
    val clouds: CurrentWeatherCloudsModel,
    val coord: CurrentWeatherCoordModel,
    val dt: Long,
    val id: Int,
    val main: CurrentWeatherMainModel,
    val name: String,
    val sys: CurrentWeatherSysModel,
    val timezone: Int,
    val visibility: Int,
    val weather: List<CurrentWeatherWeatherModel>,
    val wind: CurrentWeatherWindModel
) : BaseDataModel()