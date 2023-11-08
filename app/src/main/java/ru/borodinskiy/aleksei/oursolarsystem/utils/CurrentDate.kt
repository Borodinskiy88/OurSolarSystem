package ru.borodinskiy.aleksei.oursolarsystem.utils

import java.time.LocalDate

object CurrentDate {

    val date: LocalDate = LocalDate.now()
    val currentDate = date.toString()
    //Месяц
    private val previousMonth: LocalDate = date.minusMonths(1)
    val requestMonth = previousMonth.toString()
    //2 месяца
    private val previousTreeMonth: LocalDate = date.minusMonths(3)
    val requestTreeMonth = previousTreeMonth.toString()
    //10 дней
    private val previousTenDays: LocalDate = date.minusDays(10)
    val requestTenDays = previousTenDays.toString()

}