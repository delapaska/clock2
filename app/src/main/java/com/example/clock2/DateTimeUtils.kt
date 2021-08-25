package com.example.clock2


import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

//Date patterns
const val PATTERN_FULL_DATE = "yyyy.MM.dd HH:mm:ss"
const val PATTERN_YEAR_MONTH_DAY = "yyyy-MM-dd"
const val PATTERN_DAY_MONTH_YEAR = "dd.MM.yyyy"
const val PATTERN_HOUR_MINUTE_SECOND = "HH:mm:ss"
const val PATTERN_HOUR_MINUTE = "HH:mm"
const val PATTERN_HOUR_MINUTE_SECOND_MILLISECOND = "HH:mm:ss.SSS"
const val PATTERN_MINUTE_SECOND = "mm:ss"
const val PATTERN_FULL_DATE_INVERSE = "$PATTERN_HOUR_MINUTE_SECOND dd.MM.yyyy"
const val PATTERN_FULL_DATE_WITH_MILLISECONDS = "yyyy.MM.dd HH:mm:ss.SSSS"

// TODO getting/setting current locale
fun convertMillisToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyyy.MM.dd HH:mm:ss")
    format.timeZone = TimeZone.getTimeZone("Europe/Moscow")
    return format.format(date)
}

fun convertMillisToTime(time: Long, pattern: String): String {
    val date = Date(time)
    val format = SimpleDateFormat(pattern, Locale.US)
    format.timeZone = TimeZone.getTimeZone("Europe/Moscow")
    return format.format(date)
}

fun convertMillisToTime(time: Long, pattern: String, timeZone: TimeZone): String {
    val data = Date(time)
    val format = SimpleDateFormat(pattern)
    format.timeZone = timeZone
    return format.format(data)
}

fun convertTimeToMillis(date: String): Long {
    val format = SimpleDateFormat(PATTERN_FULL_DATE_WITH_MILLISECONDS)
    val convertedDate = format.parse(date)
    return convertedDate.time
}

fun convertTimeToMillis(date: String, pattern: String): Long {
    val format = SimpleDateFormat(pattern)
    val convertedDate = format.parse(date)
    return convertedDate.time
}

fun convertMillisToSeconds(millis: Long): Long {
    return TimeUnit.MILLISECONDS.toSeconds(millis)
}