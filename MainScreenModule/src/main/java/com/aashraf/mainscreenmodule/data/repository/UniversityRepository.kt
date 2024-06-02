package com.aashraf.mainscreenmodule.data.repository

import com.aashraf.mainscreenmodule.data.dataModel.University

interface UniversityRepository {
    suspend fun getUniversities(): List<University>
}