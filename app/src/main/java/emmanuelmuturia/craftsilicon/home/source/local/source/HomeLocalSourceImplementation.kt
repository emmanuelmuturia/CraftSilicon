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
package emmanuelmuturia.craftsilicon.home.source.local.source

import emmanuelmuturia.craftsilicon.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.craftsilicon.home.source.local.entity.CityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.remote.source.HomeRemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class HomeLocalSourceImplementation(
    private val craftSiliconDao: CraftSiliconDao,
    private val dispatcher: CoroutineDispatcher,
    private val homeRemoteSource: HomeRemoteSource,
) : HomeLocalSource {
    override suspend fun getCityWeather(city: String): Flow<CityWeatherEntity> {
        return withContext(context = dispatcher) {
            craftSiliconDao.getCityWeather().map { cityWeatherEntity ->
                CityWeatherEntity(
                    base = cityWeatherEntity.base,
                    cloudsEntity = cityWeatherEntity.cloudsEntity,
                    cod = cityWeatherEntity.cod,
                    coordEntity = cityWeatherEntity.coordEntity,
                    dt = cityWeatherEntity.dt,
                    id = cityWeatherEntity.id,
                    mainEntity = cityWeatherEntity.mainEntity,
                    name = cityWeatherEntity.name,
                    sysEntity = cityWeatherEntity.sysEntity,
                    timezone = cityWeatherEntity.timezone,
                    visibility = cityWeatherEntity.visibility,
                    weatherEntity = cityWeatherEntity.weatherEntity,
                    windEntity = cityWeatherEntity.windEntity,
                )
            }
        }.onEach {
            if (it == null) {
                homeRemoteSource.getCityWeather(city = city)
            }
        }
    }
}