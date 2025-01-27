package com.example.testtaskintern

import android.app.Application
import com.example.testtaskintern.DI.appModule
import com.example.testtaskintern.DI.databaseModule
import com.example.testtaskintern.DI.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule, databaseModule, viewModelModule)
        }
    }
}
//крашит при нажатии получить данные