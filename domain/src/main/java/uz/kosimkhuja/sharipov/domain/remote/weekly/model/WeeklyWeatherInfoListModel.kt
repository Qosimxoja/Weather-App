package uz.kosimkhuja.sharipov.domain.remote.weekly.model

data class WeeklyWeatherInfoListModel(
    val clouds: WeeklyWeatherInfoCloudsModel,
    val dt: Int,
    val dtTxt: String,
    val main: WeeklyWeatherInfoMainModel,
    val pop: Double,
    val rain: WeeklyWeatherInfoRainModel,
    val snow: WeeklyWeatherInfoSnowModel,
    val sys: WeeklyWeatherInfoSysModel,
    val visibility: Int,
    val weather: List<WeeklyWeatherInfoWeatherModel>,
    val wind: WeeklyWeatherInfoWindModel
)