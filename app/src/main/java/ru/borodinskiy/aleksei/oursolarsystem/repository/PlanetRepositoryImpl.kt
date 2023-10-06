package ru.borodinskiy.aleksei.oursolarsystem.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import ru.borodinskiy.aleksei.oursolarsystem.dao.PlanetDao
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import javax.inject.Inject

class PlanetRepositoryImpl @Inject constructor(private val planetDao: PlanetDao) :
    PlanetRepository {

    override val allPlanets: LiveData<List<Planet>> = planetDao.getPlanets().asLiveData()

    override suspend fun getPlanetFromLatinName(latinName: String): LiveData<List<Planet>> =
        planetDao.getPlanetFromLatinName(latinName).asLiveData()
}