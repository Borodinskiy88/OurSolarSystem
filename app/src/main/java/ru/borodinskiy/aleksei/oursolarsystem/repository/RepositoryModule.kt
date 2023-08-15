package ru.borodinskiy.aleksei.oursolarsystem.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun planetRepository(planetRepositoryImpl: PlanetRepositoryImpl): PlanetRepository
}