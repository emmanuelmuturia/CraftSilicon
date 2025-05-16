/*
 * Copyright 2025 Craft Silicon
 *
 * Licenced under the Apache License, Version 2.0 (the "Licence");
 * you may not use this file except in compliance with the Licence.
 * You may obtain a copy of the Licence at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */
package emmanuelmuturia.craftsilicon.main.application

import android.app.Application
import emmanuelmuturia.commons.dependencyInjection.commonsKoinModule
import emmanuelmuturia.craftsilicon.BuildConfig
import emmanuelmuturia.home.ui.dependencyInjection.homeUIKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * This is the main [Application] class for the app and acts as the entry point...
 */

class CraftSiliconApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(tree = Timber.DebugTree())
        }
        startKoin {
            androidContext(androidContext = this@CraftSiliconApplication)
            modules(
                modules =
                    listOf(
                        commonsKoinModule,
                        homeUIKoinModule,
                    ),
            )
        }
    }
}