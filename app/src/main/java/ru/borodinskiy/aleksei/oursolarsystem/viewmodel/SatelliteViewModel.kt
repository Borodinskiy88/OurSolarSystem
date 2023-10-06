package ru.borodinskiy.aleksei.oursolarsystem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite
import ru.borodinskiy.aleksei.oursolarsystem.repository.SatelliteRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class SatelliteViewModel @Inject constructor(
    private val satelliteRepository: SatelliteRepositoryImpl
) : ViewModel() {

    suspend fun getSatelliteFromPlanet(engPlanet: String): LiveData<List<Satellite>> =
        satelliteRepository.getSatelliteFromPlanet(engPlanet)

    suspend fun getSatelliteById(id: Int): LiveData<List<Satellite>> =
        satelliteRepository.getSatelliteById(id)
}