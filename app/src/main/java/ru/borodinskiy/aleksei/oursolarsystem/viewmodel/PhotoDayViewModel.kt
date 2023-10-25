package ru.borodinskiy.aleksei.oursolarsystem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.borodinskiy.aleksei.oursolarsystem.repository.nasa.PhotoDayRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class PhotoDayViewModel @Inject constructor(
    private val photoDayRepositoryImpl: PhotoDayRepositoryImpl
) : ViewModel() {

//    init {
//        getPhotoDay()
//    }

    val allPhotoDay = photoDayRepositoryImpl.allPhotoDay.asLiveData()
    fun getPhotoByDate(date : String) = photoDayRepositoryImpl.getPhotoDayById(date).asLiveData()
    fun getPhotoDay() = photoDayRepositoryImpl.getPhotoDay().asLiveData()
}