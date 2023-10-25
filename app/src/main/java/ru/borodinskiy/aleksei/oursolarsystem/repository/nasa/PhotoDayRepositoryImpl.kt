package ru.borodinskiy.aleksei.oursolarsystem.repository.nasa

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import javax.inject.Inject

class PhotoDayRepositoryImpl @Inject constructor(
    private val photoDayRepository: PhotoDayRepository
) {
    fun getPhotoDay(): Flow<PhotoDay> = flow {
        val response = photoDayRepository.getPhotoDay()
        emit(response)
    }.flowOn(Dispatchers.IO)

}