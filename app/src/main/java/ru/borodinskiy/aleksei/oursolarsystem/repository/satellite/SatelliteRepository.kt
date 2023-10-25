package ru.borodinskiy.aleksei.oursolarsystem.repository.satellite

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite

interface SatelliteRepository {

    suspend fun getSatelliteFromPlanet(engPlanet: String): LiveData<List<Satellite>>
    suspend fun getSatelliteById(id: Int): LiveData<List<Satellite>>

}