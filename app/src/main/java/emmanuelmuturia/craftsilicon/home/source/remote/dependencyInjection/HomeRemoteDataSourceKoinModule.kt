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
package emmanuelmuturia.craftsilicon.home.source.remote.dependencyInjection

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import emmanuelmuturia.craftsilicon.home.source.remote.api.OpenWeatherAPI
import emmanuelmuturia.craftsilicon.home.source.remote.source.HomeRemoteSource
import emmanuelmuturia.craftsilicon.home.source.remote.source.HomeRemoteSourceImplementation
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Retrofit

val homeRemoteDataSourceKoinModule =
    module {

        val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
        }

        single<Retrofit> {
            Retrofit.Builder()
                .addConverterFactory(json.asConverterFactory(contentType = "application/json".toMediaType()))
                .baseUrl("https://api.openweathermap.org/")
                .build()
        }

        single<OpenWeatherAPI> {
            get<Retrofit>().create(OpenWeatherAPI::class.java)
        }

        single<HomeRemoteSource> {
            HomeRemoteSourceImplementation(
                openWeatherAPI = get(),
                dispatcher = get(),
                craftSiliconDao = get(),
            )
        }
    }