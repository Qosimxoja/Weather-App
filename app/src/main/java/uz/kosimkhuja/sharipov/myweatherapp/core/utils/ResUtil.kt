package uz.kosimkhuja.sharipov.myweatherapp.core.utils

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

class ResUtil @Inject constructor(private val context: Context) {

    fun getString(@StringRes id: Int, vararg: Any) = context.resources.getString(id, vararg)

}