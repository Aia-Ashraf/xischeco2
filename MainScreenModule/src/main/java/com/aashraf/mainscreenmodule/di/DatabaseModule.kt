package com.aashraf.mainscreenmodule.di

import android.content.Context
import androidx.room.Room
import com.aashraf.mainscreenmodule.data.dataSource.localDataSource.UniversityDao
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {
    @Provides
    fun provideUniversityDao(context: Context): UniversityDao {
        val database = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()

        return database.universityDao()
    }
}