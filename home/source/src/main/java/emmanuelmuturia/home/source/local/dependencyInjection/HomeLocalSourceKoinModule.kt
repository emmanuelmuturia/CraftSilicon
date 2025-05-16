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
package emmanuelmuturia.home.source.local.dependencyInjection

import androidx.room.Room
import emmanuelmuturia.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.home.source.local.database.CraftSiliconDatabase
import emmanuelmuturia.home.source.local.source.HomeLocalSourceImplementation
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val homeLocalSourceKoinModule =
    module {

        single<CraftSiliconDatabase> {
            Room.databaseBuilder(
                context = androidContext(),
                klass = CraftSiliconDatabase::class.java,
                name = "CraftSiliconDatabase",
            ).build()
        }

        single<CraftSiliconDao> {
            get<CraftSiliconDatabase>().craftSiliconDao()
        }

        single<emmanuelmuturia.home.source.local.source.HomeLocalSource> {
            HomeLocalSourceImplementation(
                craftSiliconDao = get(),
                dispatcher = get(),
                homeRemoteSource = get(),
            )
        }
    }