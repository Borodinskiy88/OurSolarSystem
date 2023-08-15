package ru.borodinskiy.aleksei.oursolarsystem.repository

import androidx.lifecycle.LiveData
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet

interface PlanetRepository {

    val allPlanets: LiveData<List<Planet>>

    fun getPlanetFromLatinName(latinName: String): LiveData<List<Planet>>
}