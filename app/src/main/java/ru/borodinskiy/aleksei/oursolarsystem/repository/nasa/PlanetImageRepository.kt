package ru.borodinskiy.aleksei.oursolarsystem.repository.nasa

import ru.borodinskiy.aleksei.oursolarsystem.api.ApiModule
import ru.borodinskiy.aleksei.oursolarsystem.api.ApiService
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import javax.inject.Inject
import ru.borodinskiy.aleksei.oursolarsystem.api.ApiModule.Companion.NASA_URL

class PlanetImageRepository @Inject constructor(private val apiServices: ApiService) {

    suspend fun getPhotoPlanet(namePlanet : String) : PhotoDay =
        apiServices.getPhotoPlanet(
            url = NASA_URL,
            namePlanet,
//            apiKey = ApiModule.API_KEY
        )


}