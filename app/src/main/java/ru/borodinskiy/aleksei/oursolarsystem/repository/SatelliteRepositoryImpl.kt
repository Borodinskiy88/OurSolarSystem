package ru.borodinskiy.aleksei.oursolarsystem.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.Flow
import ru.borodinskiy.aleksei.oursolarsystem.dao.SatelliteDao
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite
import javax.inject.Inject

class SatelliteRepositoryImpl @Inject constructor(private val satelliteDao: SatelliteDao) :
    SatelliteRepository {
    override suspend fun getSatelliteFromPlanet(engPlanet: String): LiveData<List<Satellite>> =
        satelliteDao.getSatelliteFromPlanet(engPlanet).asLiveData()

    override suspend fun getSatelliteById(id: Int): LiveData<List<Satellite>> =
        satelliteDao.getSatelliteById(id).asLiveData()
}