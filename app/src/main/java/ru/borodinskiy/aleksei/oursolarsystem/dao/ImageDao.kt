package ru.borodinskiy.aleksei.oursolarsystem.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.borodinskiy.aleksei.oursolarsystem.entity.Image

@Dao
interface ImageDao {

    @Query("SELECT * FROM images ORDER BY id DESC")
    fun getImages(): Flow<List<Image>>

    @Query("SELECT * FROM images WHERE key_word = :keyWord")
    fun getImagesFromKeyWord(keyWord: String): Flow<List<Image>>

}