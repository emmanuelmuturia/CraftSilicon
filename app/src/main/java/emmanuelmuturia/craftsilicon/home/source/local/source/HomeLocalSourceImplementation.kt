/*
 * Copyright 2025 Craft Silicon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package emmanuelmuturia.craftsilicon.home.source.local.source

import emmanuelmuturia.craftsilicon.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentCityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.remote.source.HomeRemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class HomeLocalSourceImplementation(
    private val craftSiliconDao: CraftSiliconDao,
    private val dispatcher: CoroutineDispatcher,
    private val homeRemoteSource: HomeRemoteSource,
) : HomeLocalSource {
    override suspend fun getCurrentCityWeather(cityName: String): Flow<CurrentCityWeatherEntity?> {
        return withContext(dispatcher) {
            async {
                homeRemoteSource.getCurrentWeather(cityName = cityName)
            }.await()
            craftSiliconDao.getCurrentWeather()
        }.onEach { cachedWeather ->
            if (cachedWeather == null) {
                homeRemoteSource.getCurrentWeather(cityName = cityName)
            }
        }
    }

    override suspend fun getForecastCityWeather(cityName: String): Flow<ForecastCityWeatherEntity?> {
        return withContext(dispatcher) {
            async {
                homeRemoteSource.getForecastWeather(cityName = cityName)
            }.await()
            craftSiliconDao.getForecastWeather()
        }.onEach { cachedForecast ->
            if (cachedForecast == null) {
                homeRemoteSource.getForecastWeather(cityName = cityName)
            }
        }
    }
}