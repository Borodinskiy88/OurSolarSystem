package ru.borodinskiy.aleksei.oursolarsystem.repository.nasa

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import javax.inject.Inject

class PlanetImageRepositoryImpl @Inject constructor(
    private val planetImageRepository: PlanetImageRepository
) {
    fun getPlanetPhoto(namePlanet : String): Flow<PhotoDay> = flow {
        try {
            val response = planetImageRepository.getPhotoPlanet(namePlanet)
            emit(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)
}