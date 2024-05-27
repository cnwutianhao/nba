package com.tyhoo.android.nba.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DateUtils {

    /**
     * 今天的日期
     *
     * yyyy-MM-dd
     */
    fun getTodayDate(): String {
        val calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.format(calendar.time)
    }

    /**
     * 7天后的日期
     *
     * yyyy-MM-dd
     */
    fun getDateAfterSevenDays(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, 6)
        val dateAfterSevenDays = calendar.time
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.format(dateAfterSevenDays)
    }
}