package com.arctouch.codechallenge.util.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * Formats the date into [dd/MM/yyyy]
 */
fun Date.toDateStringFormated(): String {

    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return sdf.format(this)
}
