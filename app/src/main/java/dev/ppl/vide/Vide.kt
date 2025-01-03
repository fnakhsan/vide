package dev.ppl.vide

import android.app.Application
import dev.ppl.vide.logging.CrashAndLog
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Vide : Application() {
    override fun onCreate() {
        super.onCreate()
        CrashAndLog.setupTimber()
        startKoin {
            androidContext(this@Vide)
        }
    }
}