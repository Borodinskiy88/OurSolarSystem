package ru.borodinskiy.aleksei.oursolarsystem.repository.nasa.photoday

import ru.borodinskiy.aleksei.oursolarsystem.api.ApiService
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import javax.inject.Inject

class PhotoDayRepository @Inject constructor(private val apiServices: ApiService) {

    suspend fun getPhotoDay() : PhotoDay = apiServices.getPhotoDay()
    suspend fun getListPhotoMonth() : List<PhotoDay> = apiServices.getListPhotoMonth()
    suspend fun getListPhotoThreeMonth() : List<PhotoDay> = apiServices.getListPhotoThreeMonth()
    suspend fun getListPhotoTenDays() : List<PhotoDay> = apiServices.getListPhotoTenDays()

}