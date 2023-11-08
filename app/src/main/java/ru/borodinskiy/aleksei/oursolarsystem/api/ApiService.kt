package ru.borodinskiy.aleksei.oursolarsystem.api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import ru.borodinskiy.aleksei.oursolarsystem.api.ApiModule.Companion.API_KEY
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import ru.borodinskiy.aleksei.oursolarsystem.utils.CurrentDate.requestMonth
import ru.borodinskiy.aleksei.oursolarsystem.utils.CurrentDate.requestTenDays
import ru.borodinskiy.aleksei.oursolarsystem.utils.CurrentDate.requestTreeMonth

interface ApiService {

    @GET("planetary/apod")
    suspend fun getPhotoDay(
        @Query("api_key") apiKey: String = API_KEY,
    ): PhotoDay

    @GET("planetary/apod")
    suspend fun getListPhotoTenDays(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("start_date") date: String = requestTenDays,
    ): List<PhotoDay>

    @GET("planetary/apod")
    suspend fun getListPhotoMonth(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("start_date") date: String = requestMonth,
    ): List<PhotoDay>

    @GET("planetary/apod")
    suspend fun getListPhotoTreeMonth(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("start_date") date: String = requestTreeMonth,
    ): List<PhotoDay>

    //TODO API_KEY не нужен для библиотеки изображений, BUILD_URL другой
    @GET
    suspend fun getPhotoPlanet(
        @Url url: String,
        @Query("q") namePlanet: String,
        //       @Query("api_key") apiKey: String = API_KEY,
        @Query("media_type") mediaType: String = "image",
        @Query("page_size") pageSize: Int = 1,
    ): PhotoDay

}