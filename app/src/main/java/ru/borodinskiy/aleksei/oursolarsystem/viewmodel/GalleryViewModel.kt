package ru.borodinskiy.aleksei.oursolarsystem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.borodinskiy.aleksei.oursolarsystem.entity.Image
import ru.borodinskiy.aleksei.oursolarsystem.repository.gallery.GalleryRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val galleryRepositoryImpl: GalleryRepositoryImpl
) : ViewModel() {

    suspend fun getImagesFromKeyWord(keyWord: String): LiveData<List<Image>> =
        galleryRepositoryImpl.getImagesFromKeyWord(keyWord)

}