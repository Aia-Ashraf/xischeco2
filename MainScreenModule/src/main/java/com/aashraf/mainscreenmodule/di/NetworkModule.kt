package com.aashraf.mainscreenmodule.di

import com.aashraf.mainscreenmodule.data.dataSource.localDataSource.UniversityDao
import com.aashraf.mainscreenmodule.data.dataSource.remoteDataSource.UniversityApi
import com.aashraf.mainscreenmodule.data.dataSource.remoteDataSource.UniversityRemoteDataSource
import com.aashraf.mainscreenmodule.data.repository.UniversityRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {
    @Provides
    fun provideUniversityApi(): UniversityApi {
        return Retrofit.Builder()
            .baseUrl("http://universities.hipolabs.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UniversityApi::class.java)
    }
    @Provides
    fun provideUniversityRepository(universityApi: UniversityApi, universityDao: UniversityDao): UniversityRepository {
        return UniversityRemoteDataSource(universityApi,universityDao)
    }
}