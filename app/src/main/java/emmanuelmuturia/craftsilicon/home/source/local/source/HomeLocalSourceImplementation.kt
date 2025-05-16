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
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentCityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCityWeatherEntity
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
    override suspend fun getCurrentCityWeather(city: String): Flow<CurrentCityWeatherEntity?> {
        return withContext(context = dispatcher) {
            craftSiliconDao.getCurrentWeather().map { cityWeatherEntity ->
                cityWeatherEntity?.let {
                    CurrentCityWeatherEntity(
                        base = it.base,
                        currentCloudsEntity = cityWeatherEntity.currentCloudsEntity,
                        cod = cityWeatherEntity.cod,
                        currentCoordEntity = cityWeatherEntity.currentCoordEntity,
                        dt = cityWeatherEntity.dt,
                        id = cityWeatherEntity.id,
                        currentMainEntity = cityWeatherEntity.currentMainEntity,
                        name = cityWeatherEntity.name,
                        currentSysEntity = cityWeatherEntity.currentSysEntity,
                        timezone = cityWeatherEntity.timezone,
                        visibility = cityWeatherEntity.visibility,
                        currentWeatherEntity = cityWeatherEntity.currentWeatherEntity,
                        currentWindEntity = cityWeatherEntity.currentWindEntity,
                        lastUpdated = cityWeatherEntity.lastUpdated,
                    )
                }
            }
        }.onEach {
            if (it == null) {
                homeRemoteSource.getCurrentWeather(city = city)
            }
        }
    }

    override suspend fun getForecastCityWeather(city: String): Flow<ForecastCityWeatherEntity?> {
        return withContext(context = dispatcher) {
            craftSiliconDao.getForecastWeather().map { forecastCityWeatherEntity ->
                forecastCityWeatherEntity?.let {
                    ForecastCityWeatherEntity(
                        forecastCityEntity = it.forecastCityEntity,
                        cnt = forecastCityWeatherEntity.cnt,
                        cod = forecastCityWeatherEntity.cod,
                        list = forecastCityWeatherEntity.list,
                        message = forecastCityWeatherEntity.message,
                    )
                }
            }
        }.onEach {
            if (it == null) {
                homeRemoteSource.getForecastWeather(city = city)
            }
        }
    }
}