package uz.kosimkhuja.sharipov.domain.remote.weekly.model

import uz.kosimkhuja.sharipov.domain.base.BaseDataModel

data class WeeklyWeatherInfoModel(
    val city: WeeklyWeatherInfoCityModel,
    val cnt: Int,
    val list: List<WeeklyWeatherInfoListModel>,
) : BaseDataModel()