package com.movilehackafro.app

import android.app.Application
import com.movilehackafro.app.objects.KoinModules
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { loadKoinModules(KoinModules.all) }
    }

}