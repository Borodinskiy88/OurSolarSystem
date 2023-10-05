package ru.borodinskiy.aleksei.oursolarsystem.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import ru.borodinskiy.aleksei.oursolarsystem.R

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


}