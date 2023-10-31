package ru.borodinskiy.aleksei.oursolarsystem.api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import ru.borodinskiy.aleksei.oursolarsystem.api.ApiModule.Companion.API_KEY
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import ru.borodinskiy.aleksei.oursolarsystem.utils.CurrentDate.requestDateMonth
import ru.borodinskiy.aleksei.oursolarsystem.utils.CurrentDate.requestDateTenDays

interface ApiService {

    @GET("planetary/apod")
    suspend fun getPhotoDay(
        @Query("api_key") apiKey: String = API_KEY,
    ): PhotoDay

    @GET("planetary/apod")
    suspend fun getListPhotoMonth(
        @Query("api_key") apiKey: String = API_KEY,

        //todo запрос с определенной даты. Запрос случайного количества фотографий
        @Query("start_date") date: String = requestDateMonth,
//        @Query("count") count: Int = 30,

    ): List<PhotoDay>

    @GET("planetary/apod")
    suspend fun getListPhotoTenDays(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("start_date") date: String = requestDateTenDays,
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