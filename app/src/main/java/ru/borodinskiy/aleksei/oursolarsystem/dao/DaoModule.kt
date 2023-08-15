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
    fun provideCarDao(db: AppDatabase): PlanetDao = db.planetDao()
}