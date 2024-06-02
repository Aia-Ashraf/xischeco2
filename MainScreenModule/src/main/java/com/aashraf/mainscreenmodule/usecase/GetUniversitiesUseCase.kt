package com.aashraf.mainscreenmodule.usecase

import com.aashraf.mainscreenmodule.data.dataModel.University
import com.aashraf.mainscreenmodule.data.repository.UniversityRepository

class GetUniversitiesUseCase(private val repository: UniversityRepository) {

    suspend operator fun invoke(): List<University> {
        return repository.getUniversities()
    }
}