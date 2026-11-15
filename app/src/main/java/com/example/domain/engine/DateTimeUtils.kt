package com.example.domain.engine

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object DateTimeUtils {
    private const val MILLIS_PER_DAY = 86_400_000L

    fun currentEpochDay(nowMillis: Long = System.currentTimeMillis(), timeZone: TimeZone = TimeZone.getDefault()): Long {
        val offset = timeZone.getOffset(nowMillis)
        return (nowMillis + offset) / MILLIS_PER_DAY
    }

    fun epochDayToStartMillis(epochDay: Long, timeZone: TimeZone = TimeZone.getDefault()): Long {
        val utcApprox = epochDay * MILLIS_PER_DAY
        val offset = timeZone.getOffset(utcApprox)
        return utcApprox - offset
    }

    fun weekIndex(epochDay: Long): Long = epochDay / 7L

    fun formatShortDate(epochDay: Long): String {
        val sdf = SimpleDateFormat("MMM d", Locale.getDefault())
        return sdf.format(Date(epochDayToStartMillis(epochDay)))
    }

    fun formatFullDateTime(millis: Long): String {
        val sdf = SimpleDateFormat("MMM d, yyyy • h:mm a", Locale.getDefault())
        return sdf.format(Date(millis))
    }

    fun dayOfMonthLabel(epochDay: Long): String {
        val cal = Calendar.getInstance().apply {
            timeInMillis = epochDayToStartMillis(epochDay)
        }
        return cal.get(Calendar.DAY_OF_MONTH).toString()
    }

    fun formatTimeOfDay(hour: Int, minute: Int): String {
        val cal = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
        }
        val sdf = SimpleDateFormat("h:mm a", Locale.getDefault())
        return sdf.format(cal.time)
    }
}
