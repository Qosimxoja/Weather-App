package uz.kosimkhuja.sharipov.data.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

const val empty: String = ""

fun Int?.orZero(): Int = this ?: 0

fun Long?.orZero(): Long = this ?: 0L

fun Double?.orZero(): Double = this ?: 0.0

fun String.space(with: String) = "$this $with"

fun SimpleDateFormat.parseOrNull(date: String): Date? =
    try {
        this.parse(date)
    } catch (e: Exception) {
        null
    }

fun SimpleDateFormat.formatOrNull(date: Date?): String =
    if (date != null)
        try {
            this.format(date)
        } catch (e: Exception) {
            empty
        }
    else empty

fun (() -> Unit)?.orDoNothing() = this ?: {}