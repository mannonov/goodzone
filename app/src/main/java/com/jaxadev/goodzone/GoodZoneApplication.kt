package com.jaxadev.goodzone

import android.app.Application
import timber.log.BuildConfig
import timber.log.Timber

class GoodZoneApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {

            Timber.plant(Timber.DebugTree())

        }

    }

}