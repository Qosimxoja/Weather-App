package uz.kosimkhuja.sharipov.myweatherapp.core.utils

import uz.kosimkhuja.sharipov.data.extensions.formatOrNull
import uz.kosimkhuja.sharipov.data.extensions.parseOrNull
import uz.kosimkhuja.sharipov.myweatherapp.core.constants.Constants
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateUtils {

    fun formatRemoteDate(date: String, fromPattern: String, toPattern: String): String {
        return SimpleDateFormat(toPattern, Locale.getDefault())
            .formatOrNull(
                date = SimpleDateFormat(
                    fromPattern,
                    Locale.getDefault()
                ).parseOrNull(date = date)
            )
    }

    fun longToString(date: Long, pattern: String = Constants.CONVERTOR_DATE_PATTERN): String =
        SimpleDateFormat(pattern, Locale.getDefault()).format(Date(date.times(1000)))
}