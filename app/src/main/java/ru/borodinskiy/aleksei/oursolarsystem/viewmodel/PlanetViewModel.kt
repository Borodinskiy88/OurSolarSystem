package ru.borodinskiy.aleksei.oursolarsystem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import ru.borodinskiy.aleksei.oursolarsystem.repository.PlanetRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor(
    private val planetRepository: PlanetRepositoryImpl,
) : ViewModel() {

    suspend fun getPlanetFromLatinName(latinName: String): LiveData<List<Planet>> =
        planetRepository.getPlanetFromLatinName(latinName)

}
