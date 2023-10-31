package ru.borodinskiy.aleksei.oursolarsystem.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay

@Dao
interface PhotoDayDao {

    @Query("SELECT * FROM PhotoDay ORDER BY date DESC")
    fun getPhotoDay(): Flow<List<PhotoDay>>

    @Query("SELECT * from PhotoDay WHERE date = :date")
    fun getPhotoDayByDate(date : String): Flow<List<PhotoDay>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(photoDay: PhotoDay)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(listPhotoDay: List<PhotoDay>)

    @Delete
    suspend fun delete(photoDay: PhotoDay)
}