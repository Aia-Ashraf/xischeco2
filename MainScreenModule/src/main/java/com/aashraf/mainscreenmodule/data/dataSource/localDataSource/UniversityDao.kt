package com.aashraf.mainscreenmodule.data.dataSource.localDataSource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.aashraf.mainscreenmodule.data.dataModel.University

@Dao
interface UniversityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(universities: List<University>)
}