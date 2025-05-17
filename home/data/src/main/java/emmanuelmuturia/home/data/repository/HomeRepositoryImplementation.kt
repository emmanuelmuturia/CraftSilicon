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
package emmanuelmuturia.home.data.repository

import emmanuelmuturia.home.data.model.current.CurrentCityWeather
import emmanuelmuturia.home.data.model.current.toCoord
import emmanuelmuturia.home.data.model.current.toCurrentClouds
import emmanuelmuturia.home.data.model.current.toMain
import emmanuelmuturia.home.data.model.current.toSys
import emmanuelmuturia.home.data.model.current.toWeather
import emmanuelmuturia.home.data.model.current.toWind
import emmanuelmuturia.home.data.model.forecast.ForecastCityWeather
import emmanuelmuturia.home.data.model.forecast.toForecastCity
import emmanuelmuturia.home.data.model.forecast.toForecastWeatherItem
import emmanuelmuturia.home.source.local.source.HomeLocalSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class HomeRepositoryImplementation(
    private val homeLocalSource: HomeLocalSource,
    private val dispatcher: CoroutineDispatcher,
) : HomeRepository {
    override suspend fun getCurrentCityWeather(cityName: String): Flow<CurrentCityWeather?> {
        return withContext(context = dispatcher) {
            homeLocalSource.getCurrentCityWeather(cityName = cityName).map { cityWeatherEntity ->
                cityWeatherEntity?.let {
                    CurrentCityWeather(
                        base = it.base,
                        currentClouds = cityWeatherEntity.currentCloudsEntity.toCurrentClouds(),
                        cod = cityWeatherEntity.cod,
                        currentCoord = cityWeatherEntity.currentCoordEntity.toCoord(),
                        dt = cityWeatherEntity.dt,
                        id = cityWeatherEntity.id,
                        currentMain = cityWeatherEntity.currentMainEntity.toMain(),
                        name = cityWeatherEntity.name,
                        currentSys = cityWeatherEntity.currentSysEntity.toSys(),
                        timezone = cityWeatherEntity.timezone,
                        visibility = cityWeatherEntity.visibility,
                        currentWeather = cityWeatherEntity.currentWeatherEntity.map { weatherEntity -> weatherEntity.toWeather() },
                        currentWind = cityWeatherEntity.currentWindEntity.toWind(),
                        lastUpdated = cityWeatherEntity.lastUpdated,
                    )
                }
            }
        }
    }

    override suspend fun getForecastCityWeather(cityName: String): Flow<ForecastCityWeather?> {
        return withContext(context = dispatcher) {
            homeLocalSource.getForecastCityWeather(cityName = cityName).map { forecastCityWeatherEntity ->
                forecastCityWeatherEntity?.forecastCityEntity?.let {
                    ForecastCityWeather(
                        forecastCity = it.toForecastCity(),
                        cnt = forecastCityWeatherEntity.cnt,
                        cod = forecastCityWeatherEntity.cod,
                        list =
                            forecastCityWeatherEntity.list.map { forecastCityWeatherEntityList ->
                                forecastCityWeatherEntityList.toForecastWeatherItem()
                            },
                        message = forecastCityWeatherEntity.message,
                        lastUpdated = forecastCityWeatherEntity.list.first().lastUpdated
                    )
                }
            }
        }
    }

    override suspend fun getWeatherByCityName(cityName: String) {
        withContext(context = dispatcher) {
            homeLocalSource.getWeatherByCityName(cityName = cityName)
        }
    }
}