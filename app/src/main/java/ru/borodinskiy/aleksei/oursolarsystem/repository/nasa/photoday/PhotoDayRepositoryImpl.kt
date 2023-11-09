package ru.borodinskiy.aleksei.oursolarsystem.repository.nasa.photoday

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

    fun getPhotoDayById(date: String) = dao.getPhotoDayByDate(date)

    fun getPhotoDay(): Flow<PhotoDay> = flow {
        try {
            val response = photoDayRepository.getPhotoDay()
            emit(response)
            dao.insert(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)

    fun getListPhotoMonth(): Flow<List<PhotoDay>> = flow {
        try {
            val response = photoDayRepository.getListPhotoMonth()
            emit(response)
            dao.insertList(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)

    fun getListPhotoThreeMonth(): Flow<List<PhotoDay>> = flow {
        try {
            val response = photoDayRepository.getListPhotoThreeMonth()
            emit(response)
            dao.insertList(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)

    fun getListPhotoTenDays(): Flow<List<PhotoDay>> = flow {
        try {
            val response = photoDayRepository.getListPhotoTenDays()
            emit(response)
            dao.insertList(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)

    suspend fun delete(photoDay: PhotoDay) = dao.delete(photoDay)
    suspend fun deleteAll() = dao.deleteAll()

}