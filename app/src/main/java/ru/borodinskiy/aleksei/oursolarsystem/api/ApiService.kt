package ru.borodinskiy.aleksei.oursolarsystem.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.borodinskiy.aleksei.oursolarsystem.api.ApiModule.Companion.API_KEY
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay

interface ApiService {

    @GET("planetary/apod")
    suspend fun getPhotoDay(
        @Query("api_key") apiKey: String = API_KEY,

    ): PhotoDay

}