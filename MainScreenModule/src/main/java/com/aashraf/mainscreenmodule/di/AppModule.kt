package com.aashraf.mainscreenmodule.di

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.aashraf.mainscreenmodule.presentation.view.MainListAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager = LinearLayoutManager(context)

    @Provides
    @Singleton
    fun provideListAdapter(): MainListAdapter = MainListAdapter(emptyList())
}