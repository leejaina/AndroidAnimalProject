package com.example.androidanimalproject.di

import com.example.androidanimalproject.data.AnimalService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providesAnimalService(retrofit: Retrofit): AnimalService =
        retrofit.create(AnimalService::class.java)
}