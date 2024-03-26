package ru.borodinskiy.aleksei.oursolarsystem.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppDatabaseModule {

    @Singleton
    @Provides
    fun provideDb(
        @ApplicationContext
        context: Context
    ): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "our_solar_system")
        .createFromAsset("database/our_solar_system.db")
        .build()

}