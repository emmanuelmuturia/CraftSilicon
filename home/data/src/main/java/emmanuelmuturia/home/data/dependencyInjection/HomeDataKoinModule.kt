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
package emmanuelmuturia.home.data.dependencyInjection

import emmanuelmuturia.home.data.repository.HomeRepository
import emmanuelmuturia.home.data.repository.HomeRepositoryImplementation
import emmanuelmuturia.home.source.local.dependencyInjection.homeLocalSourceKoinModule
import emmanuelmuturia.home.source.remote.dependencyInjection.homeRemoteDataSourceKoinModule
import org.koin.dsl.module

val homeDataKoinModule =
    module {

        single<HomeRepository> {
            HomeRepositoryImplementation(
                homeLocalSource = get(),
                dispatcher = get(),
            )
        }

        includes(
            module =
                listOf(
                    homeLocalSourceKoinModule,
                    homeRemoteDataSourceKoinModule,
                ),
        )
    }