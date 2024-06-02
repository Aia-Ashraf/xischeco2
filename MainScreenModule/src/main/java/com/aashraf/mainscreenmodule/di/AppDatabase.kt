package com.aashraf.mainscreenmodule.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aashraf.mainscreenmodule.data.dataModel.University
import com.aashraf.mainscreenmodule.data.dataSource.localDataSource.UniversityDao

@Database(entities = [University::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun universityDao(): UniversityDao
}