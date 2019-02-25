package com.example.mikhail.currencyexchangerate.utils

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {

    @JvmStatic
    fun formatDate(time: Int?): String {
        if (time != null) {
            val date = Date(time.times(1000L))
            val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
            return sdf.format(date)
        } else {
            return ""
        }
    }

    @JvmStatic
    fun formatDouble(double: Double?): String {
        val format = DecimalFormat("0.00000")
        return format.format(double)
    }


}