package ru.borodinskiy.aleksei.oursolarsystem.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.borodinskiy.aleksei.oursolarsystem.dao.ImageDao
import ru.borodinskiy.aleksei.oursolarsystem.dao.PhotoDayDao
import ru.borodinskiy.aleksei.oursolarsystem.dao.PlanetDao
import ru.borodinskiy.aleksei.oursolarsystem.dao.SatelliteDao
import ru.borodinskiy.aleksei.oursolarsystem.entity.Image
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite

@Database(
    entities = [
        Planet::class,
        Satellite::class,
        PhotoDay::class,
        Image::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun planetDao(): PlanetDao
    abstract fun satelliteDao(): SatelliteDao
    abstract fun photoDayDao(): PhotoDayDao
    abstract fun imageDao(): ImageDao

}