package ru.borodinskiy.aleksei.oursolarsystem.repository

import androidx.lifecycle.LiveData
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite

interface PlanetRepository {

    val allPlanets: LiveData<List<Planet>>

    suspend fun getPlanetFromLatinName(latinName: String): LiveData<List<Planet>>

}