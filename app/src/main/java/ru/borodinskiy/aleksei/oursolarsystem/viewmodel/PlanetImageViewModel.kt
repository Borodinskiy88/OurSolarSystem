package ru.borodinskiy.aleksei.oursolarsystem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.borodinskiy.aleksei.oursolarsystem.repository.nasa.PlanetImageRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class PlanetImageViewModel @Inject constructor(
    private val planetImageRepositoryImpl: PlanetImageRepositoryImpl
) : ViewModel() {

    fun getPhotoPlanet(namePlanet : String) =
        planetImageRepositoryImpl.getPlanetPhoto(namePlanet).asLiveData()

}