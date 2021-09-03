package com.volcanolabs.multiplesapp.di

import com.volcanolabs.multiplesapp.data.MultiplesDataRepository
import com.volcanolabs.multiplesapp.data.MultiplesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MultiplesRepositoryModule {
    @Binds
    abstract fun bindMultiplesRepository(multiplesRepository: MultiplesDataRepository): MultiplesRepository
}