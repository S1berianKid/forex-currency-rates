package com.example.mikhail.currencyexchangerate.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {

    @JvmStatic
    fun format(time: Int?): String {
        if (time != null) {
            val date = Date(time.times(1000L))
            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            return sdf.format(date)
        } else {
            return ""
        }

    }
}
