package ru.borodinskiy.aleksei.oursolarsystem.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite

@Dao
interface SatelliteDao {
    @Query("SELECT * FROM satellite ORDER BY id DESC")
    fun getSatellite(): Flow<List<Satellite>>

    @Query("SELECT * FROM satellite WHERE eng_planet = :engPlanet")
    fun getSatelliteFromPlanet(engPlanet: String): Flow<List<Satellite>>

    @Query("SELECT * FROM satellite WHERE id = :id")
    fun getSatelliteById(id: Int): Flow<List<Satellite>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(satellite: Satellite)

    @Update
    suspend fun update(satellite: Satellite)

    @Delete
    suspend fun delete(satellite: Satellite)

    @Upsert
    suspend fun save(satellite: Satellite)

}