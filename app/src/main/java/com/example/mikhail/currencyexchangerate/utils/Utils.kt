package com.example.mikhail.currencyexchangerate.utils

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {

    fun formatDate(time: Int?): String {

        return if (time != null) {
            val date = Date(time.times(1000L))
            val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
            sdf.format(date)
        } else {
            ""
        }

    }

    fun formatDouble(double: Double?): String {
        return if (double != null) {
            val format = DecimalFormat("0.00000")
            format.format(double)
        } else {
            ""
        }
    }


}
