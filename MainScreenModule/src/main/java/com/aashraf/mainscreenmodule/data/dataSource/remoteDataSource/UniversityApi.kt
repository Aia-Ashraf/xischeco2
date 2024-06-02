package com.aashraf.mainscreenmodule.data.dataSource.remoteDataSource

import com.aashraf.mainscreenmodule.data.dataModel.University
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response


interface UniversityApi {
    @GET("search")
    suspend fun getUniversities(@Query("country") country: String): Response<List<University>>
}