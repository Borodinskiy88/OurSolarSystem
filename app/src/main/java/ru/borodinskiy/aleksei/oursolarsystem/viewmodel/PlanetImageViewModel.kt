package ru.borodinskiy.aleksei.oursolarsystem.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.borodinskiy.aleksei.oursolarsystem.repository.nasa.planetimage.PlanetImageRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class PlanetImageViewModel @Inject constructor(
    private val planetImageRepositoryImpl: PlanetImageRepositoryImpl
) : ViewModel() {

//    fun getPhotoPlanet(searchText : String) =
//        planetImageRepositoryImpl.getPlanetPhoto(searchText).asLiveData()

}