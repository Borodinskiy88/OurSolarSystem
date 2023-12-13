package ru.borodinskiy.aleksei.oursolarsystem.repository.gallery

import androidx.lifecycle.LiveData
import ru.borodinskiy.aleksei.oursolarsystem.entity.Image

interface GalleryRepository {

    val allImages: LiveData<List<Image>>

    suspend fun getImagesFromKeyWord(keyWord: String): LiveData<List<Image>>
}