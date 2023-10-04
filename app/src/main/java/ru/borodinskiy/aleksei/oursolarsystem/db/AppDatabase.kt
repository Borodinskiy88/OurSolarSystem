package ru.borodinskiy.aleksei.oursolarsystem.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.borodinskiy.aleksei.oursolarsystem.dao.PlanetDao
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite

@Database(entities = [Planet::class, Satellite::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun planetDao(): PlanetDao

}