package com.aashraf.mainscreenmodule.data.dataSource.remoteDataSource

import com.aashraf.mainscreenmodule.data.dataModel.University
import com.aashraf.mainscreenmodule.data.repository.UniversityRepository
import com.aashraf.mainscreenmodule.data.dataSource.localDataSource.UniversityDao

class UniversityRemoteDataSource(
    private val universityApi: UniversityApi,
    private val universityDao: UniversityDao
) : UniversityRepository {

    override suspend fun getUniversities(): List<University> {
        val response = universityApi.getUniversities("United Arab Emirates")
        if (response.isSuccessful) {
            val universities = response.body() ?: emptyList()
            universityDao.insertAll(universities)
            return universities
        } else {
            throw Exception("HTTP error ${response.code()}")
        }
    }
}