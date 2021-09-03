package com.volcanolabs.multiplesapp.di

import android.content.Context
import androidx.room.Room
import com.volcanolabs.multiplesapp.data.MultiplesDao
import com.volcanolabs.multiplesapp.data.MultiplesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MultiplesDatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MultiplesDatabase {
        return Room
            .databaseBuilder(context, MultiplesDatabase::class.java, "Multiples-database")
            .build()
    }

    @Provides
    fun provideMultiplesDao(multiplesDatabase: MultiplesDatabase): MultiplesDao {
        return multiplesDatabase.multiplesDao()
    }
}