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

    fun getPhotoDay() = photoDayRepositoryImpl.getPhotoDay().asLiveData()
}