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
package emmanuelmuturia.craftsilicon.home.data.repository

import emmanuelmuturia.craftsilicon.home.data.model.CityWeather
import emmanuelmuturia.craftsilicon.home.data.model.toClouds
import emmanuelmuturia.craftsilicon.home.data.model.toCoord
import emmanuelmuturia.craftsilicon.home.data.model.toMain
import emmanuelmuturia.craftsilicon.home.data.model.toSys
import emmanuelmuturia.craftsilicon.home.data.model.toWeather
import emmanuelmuturia.craftsilicon.home.data.model.toWind
import emmanuelmuturia.craftsilicon.home.source.local.source.HomeLocalSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class HomeRepositoryImplementation(
    private val homeLocalSource: HomeLocalSource,
    private val dispatcher: CoroutineDispatcher,
) : HomeRepository {
    override suspend fun getCityWeather(city: String): Flow<CityWeather> {
        return withContext(context = dispatcher) {
            homeLocalSource.getCityWeather(city = city).map { cityWeatherEntity ->
                CityWeather(
                    base = cityWeatherEntity.base,
                    clouds = cityWeatherEntity.cloudsEntity.toClouds(),
                    cod = cityWeatherEntity.cod,
                    coord = cityWeatherEntity.coordEntity.toCoord(),
                    dt = cityWeatherEntity.dt,
                    id = cityWeatherEntity.id,
                    main = cityWeatherEntity.mainEntity.toMain(),
                    name = cityWeatherEntity.name,
                    sys = cityWeatherEntity.sysEntity.toSys(),
                    timezone = cityWeatherEntity.timezone,
                    visibility = cityWeatherEntity.visibility,
                    weather = cityWeatherEntity.weatherEntity.map { weatherEntity -> weatherEntity.toWeather() },
                    wind = cityWeatherEntity.windEntity.toWind(),
                )
            }
        }
    }
}