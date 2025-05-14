package emmanuelmuturia.craftsilicon.main.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * This is the main [Application] class for the app and acts as the entry point...
 */

class CraftSiliconApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(androidContext = this@CraftSiliconApplication)
            modules(modules = listOf(
c
            ))
        }
    }
}