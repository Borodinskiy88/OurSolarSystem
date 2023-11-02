package ru.borodinskiy.aleksei.oursolarsystem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import ru.borodinskiy.aleksei.oursolarsystem.repository.nasa.PhotoDayRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class PhotoDayViewModel @Inject constructor(
    private val photoDayRepositoryImpl: PhotoDayRepositoryImpl
) : ViewModel() {

    val allPhotoDay = photoDayRepositoryImpl.allPhotoDay.asLiveData()
    fun getPhotoByDate(date : String) = photoDayRepositoryImpl.getPhotoDayById(date).asLiveData()
    fun getPhotoDay() = photoDayRepositoryImpl.getPhotoDay().asLiveData()
    fun getListPhotoMonth() = photoDayRepositoryImpl.getListPhotoMonth().asLiveData()
    fun getListPhotoTwoMonth() = photoDayRepositoryImpl.getListPhotoTwoMonth().asLiveData()
    fun getListPhotoTenDays() = photoDayRepositoryImpl.getListPhotoTenDays().asLiveData()

    fun delete(photoDay : PhotoDay) {
        viewModelScope.launch {
            photoDayRepositoryImpl.delete(photoDay)
        }
    }
    

}