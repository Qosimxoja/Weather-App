package uz.kosimkhuja.sharipov.data.remote.weekly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.kosimkhuja.sharipov.data.base.BaseResponse
import uz.kosimkhuja.sharipov.data.extensions.orZero
import uz.kosimkhuja.sharipov.domain.remote.weekly.model.WeeklyWeatherInfoModel

@Serializable
data class WeeklyWeatherInfoResponse(
    @SerialName("city")
    val city: WeeklyWeatherInfoCity? = null,
    @SerialName("cnt")
    val cnt: Int? = null,
    @SerialName("list")
    val list: List<WeeklyWeatherInfoList?>? = null,
) : BaseResponse()

fun WeeklyWeatherInfoResponse?.toDomain() = WeeklyWeatherInfoModel(
    city = this?.city.toDomain(),
    cnt = this?.cnt.orZero(),
    list = this?.list.orEmpty().map { it.toDomain() }
).apply {
    code = this@toDomain?.code.orZero()
    message = this@toDomain?.message.orZero()
}