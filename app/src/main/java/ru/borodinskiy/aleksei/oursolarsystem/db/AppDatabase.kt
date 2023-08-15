package ru.borodinskiy.aleksei.oursolarsystem.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.borodinskiy.aleksei.oursolarsystem.dao.PlanetDao
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet

@Database(entities = [Planet::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun planetDao(): PlanetDao

}