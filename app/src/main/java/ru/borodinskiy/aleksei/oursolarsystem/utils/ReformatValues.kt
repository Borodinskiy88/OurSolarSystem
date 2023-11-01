package ru.borodinskiy.aleksei.oursolarsystem.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Locale

object ReformatValues {

    fun reformatCount(count: Int): String {
        val formatCount = when {
            count in 1000..9999 -> {
                String.format("%.1f тыс.", count / 1000.0)
            }

            count in 10000..999999 -> {
                String.format("%d тыс.", count / 1000)
            }

            count >= 1000000 -> {
                String.format("%.1f млн.", count / 1000000.0)
            }

            else -> count.toString()
        }
        return formatCount
    }
    @SuppressLint("SimpleDateFormat")
    fun reformatTime(date: String): String {
        val timeObj = SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date)
        val currentTime =
            timeObj?.let { SimpleDateFormat("HH:mm", Locale("ru")).format(it) }
        return currentTime.toString()
    }
    @SuppressLint("SimpleDateFormat")
    fun reformatDate(date: String): String {
        val dateObj = SimpleDateFormat("yyyy-MM-dd").parse(date)
        val reformatDate = dateObj?.let { SimpleDateFormat("dd-MM-yyyy", Locale("ru")).format(it) }
        return reformatDate.toString()
    }

    fun reformatWebLink(url: String): String {
        val removeHttps = url.substringAfterLast("/")
        return removeHttps.substringBeforeLast("?")
    }

}