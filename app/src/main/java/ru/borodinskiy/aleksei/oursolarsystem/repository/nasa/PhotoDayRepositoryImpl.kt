package ru.borodinskiy.aleksei.oursolarsystem.repository.nasa

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.borodinskiy.aleksei.oursolarsystem.dao.PhotoDayDao
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import javax.inject.Inject

class PhotoDayRepositoryImpl @Inject constructor(
    private val photoDayRepository: PhotoDayRepository,
    private val dao: PhotoDayDao
) {

    val allPhotoDay = dao.getPhotoDay()

    fun getPhotoDayById(date : String) = dao.getPhotoDayByDate(date)

    fun getPhotoDay(): Flow<PhotoDay> = flow {
        try {
            val response = photoDayRepository.getPhotoDay()
            emit(response)
            dao.insert(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)

}