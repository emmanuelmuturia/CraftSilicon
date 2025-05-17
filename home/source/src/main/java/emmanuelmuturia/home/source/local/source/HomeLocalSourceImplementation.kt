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
package emmanuelmuturia.home.source.local.source

import emmanuelmuturia.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.home.source.local.entity.current.CurrentCityWeatherEntity
import emmanuelmuturia.home.source.local.entity.forecast.ForecastCityWeatherEntity
import emmanuelmuturia.home.source.remote.source.HomeRemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

/**
 * This is the implementation of the Local Data Source for the :home module...
 */

class HomeLocalSourceImplementation(
    private val craftSiliconDao: CraftSiliconDao,
    private val dispatcher: CoroutineDispatcher,
    private val homeRemoteSource: HomeRemoteSource,
) : HomeLocalSource {
    override suspend fun getCurrentCityWeather(cityName: String): Flow<CurrentCityWeatherEntity?> {
        return withContext(dispatcher) {
            craftSiliconDao.getCurrentWeather()
        }.onEach { cachedWeather ->
            if (cachedWeather == null) {
                homeRemoteSource.getCurrentWeather(cityName = cityName)
            }
        }
    }

    override suspend fun getForecastCityWeather(cityName: String): Flow<ForecastCityWeatherEntity?> {
        return withContext(dispatcher) {
            craftSiliconDao.getForecastWeather()
        }.onEach { cachedForecast ->
            if (cachedForecast == null) {
                homeRemoteSource.getForecastWeather(cityName = cityName)
            }
        }
    }

    override suspend fun getWeatherByCityName(cityName: String) {
        withContext(context = dispatcher) {
            async {
                homeRemoteSource.getCurrentWeather(cityName = cityName)
                homeRemoteSource.getForecastWeather(cityName = cityName)
            }.await()
            craftSiliconDao.getCurrentWeather()
            craftSiliconDao.getForecastWeather()
        }
    }
}