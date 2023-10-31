package ru.borodinskiy.aleksei.oursolarsystem.utils

import java.time.LocalDate

object CurrentDate {

    val date: LocalDate = LocalDate.now()
    //Месяц
    private val previousDateMonth: LocalDate = date.minusMonths(1)
    val requestDateMonth = previousDateMonth.toString()
    //10 дней
    private val previousDateTenDays: LocalDate = date.minusDays(10)
    val requestDateTenDays = previousDateTenDays.toString()

}