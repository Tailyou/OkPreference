package com.hengda.zwf.okpreference

import android.app.Application

class PreferenceHolderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceHolder.setContext(applicationContext)
    }
}