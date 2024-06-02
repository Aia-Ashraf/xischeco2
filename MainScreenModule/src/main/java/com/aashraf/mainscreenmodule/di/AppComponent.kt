package com.aashraf.mainscreenmodule.di

import androidx.lifecycle.ViewModelProvider
import com.aashraf.mainscreenmodule.presentation.view.ListMainActivity
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, UseCaseModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(activity: ListMainActivity)
}