package ru.borodinskiy.aleksei.oursolarsystem.repository.nasa

import androidx.lifecycle.LiveData
import ru.borodinskiy.aleksei.oursolarsystem.api.ApiModule.Companion.API_KEY
import ru.borodinskiy.aleksei.oursolarsystem.api.ApiService
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import javax.inject.Inject

class PhotoDayRepository @Inject constructor(private val apiServices: ApiService) {

    suspend fun getPhotoDay() : PhotoDay = apiServices.getPhotoDay(apiKey = API_KEY)
}