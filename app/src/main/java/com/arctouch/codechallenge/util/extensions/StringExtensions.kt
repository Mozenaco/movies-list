package com.arctouch.codechallenge.util.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Formats the a string with format yyyy-MM-dd into Date
 */
fun String.toDate(): Date? {

    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    try {
        return format.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return null
}