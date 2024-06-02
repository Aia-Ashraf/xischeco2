package com.aashraf.mainscreenmodule.di

import com.aashraf.mainscreenmodule.data.repository.UniversityRepository
import com.aashraf.mainscreenmodule.usecase.GetUniversitiesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetUniversitiesUseCase(repository: UniversityRepository): GetUniversitiesUseCase {
        return GetUniversitiesUseCase(repository)
    }
}