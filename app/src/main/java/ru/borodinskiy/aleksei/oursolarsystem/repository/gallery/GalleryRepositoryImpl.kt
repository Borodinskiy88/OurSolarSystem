package ru.borodinskiy.aleksei.oursolarsystem.repository.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import ru.borodinskiy.aleksei.oursolarsystem.dao.ImageDao
import ru.borodinskiy.aleksei.oursolarsystem.entity.Image
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val imageDao: ImageDao
) : GalleryRepository {

    override val allImages: LiveData<List<Image>> = imageDao.getImages().asLiveData()
    override suspend fun getImagesFromKeyWord(keyWord: String): LiveData<List<Image>> =
        imageDao.getImagesFromKeyWord(keyWord).asLiveData()

}