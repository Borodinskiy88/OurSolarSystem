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

@Dao
interface PlanetDao {

    @Query("SELECT * FROM planets_db ORDER BY id DESC")
    fun getPlanets(): Flow<List<Planet>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(planet: Planet)

    @Query("SELECT * FROM planets_db WHERE latin_name = :latinName")
    fun getPlanetFromLatinName(latinName: String): Flow<List<Planet>>

    @Update
    suspend fun update(planet: Planet)

    @Delete
    suspend fun delete(planet: Planet)

    @Upsert
    suspend fun save(planet: Planet)


}