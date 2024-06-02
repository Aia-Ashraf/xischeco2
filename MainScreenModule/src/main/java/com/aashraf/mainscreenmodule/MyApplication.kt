package com.aashraf.mainscreenmodule

import android.app.Application
import com.aashraf.mainscreenmodule.di.AppComponent
import com.aashraf.mainscreenmodule.di.AppModule
import com.aashraf.mainscreenmodule.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}