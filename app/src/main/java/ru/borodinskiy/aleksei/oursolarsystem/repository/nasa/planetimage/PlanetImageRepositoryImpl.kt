package ru.borodinskiy.aleksei.oursolarsystem.repository.nasa.planetimage

import javax.inject.Inject

class PlanetImageRepositoryImpl @Inject constructor(
    private val planetImageRepository: PlanetImageRepository
) {
//    fun getPlanetPhoto(searchText : String): Flow<PhotoDay> = flow {
//        try {
//            val response = planetImageRepository.getPhotoPlanet(searchText)
//            emit(response)
//        } catch (e: Exception) {
//            return@flow
//        }
//    }.flowOn(Dispatchers.IO)
}