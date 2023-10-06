package ru.borodinskiy.aleksei.oursolarsystem.dao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.borodinskiy.aleksei.oursolarsystem.db.AppDatabase

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {
    @Provides
    fun providePlanetDao(db: AppDatabase): PlanetDao = db.planetDao()
    @Provides
    fun provideSatelliteDao(db: AppDatabase): SatelliteDao = db.satelliteDao()
}