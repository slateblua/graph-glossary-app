package com.slateblua.graphglossary

import android.app.Application
import com.slateblua.graphglossary.appmodule.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GlossaryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GlossaryApp)
            modules(commonModule)
        }.koin
    }
}