package uz.kosimkhuja.sharipov.data.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class BaseResponse(
    @SerialName("cod")
    val code: Int? = null,
    @SerialName("message")
    val message: Int? = null
)