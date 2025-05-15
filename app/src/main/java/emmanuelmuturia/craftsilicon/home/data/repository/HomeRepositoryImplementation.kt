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

import emmanuelmuturia.craftsilicon.home.data.model.current.CurrentCityWeather
import emmanuelmuturia.craftsilicon.home.data.model.current.toClouds
import emmanuelmuturia.craftsilicon.home.data.model.current.toCoord
import emmanuelmuturia.craftsilicon.home.data.model.current.toMain
import emmanuelmuturia.craftsilicon.home.data.model.current.toSys
import emmanuelmuturia.craftsilicon.home.data.model.current.toWeather
import emmanuelmuturia.craftsilicon.home.data.model.current.toWind
import emmanuelmuturia.craftsilicon.home.data.model.forecast.ForecastCityWeather
import emmanuelmuturia.craftsilicon.home.data.model.forecast.toForecastCity
import emmanuelmuturia.craftsilicon.home.data.model.forecast.toForecastWeatherItem
import emmanuelmuturia.craftsilicon.home.source.local.source.HomeLocalSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class HomeRepositoryImplementation(
    private val homeLocalSource: HomeLocalSource,
    private val dispatcher: CoroutineDispatcher,
) : HomeRepository {
    override suspend fun getCurrentCityWeather(city: String): Flow<CurrentCityWeather> {
        return withContext(context = dispatcher) {
            homeLocalSource.getCurrentCityWeather(city = city).map { cityWeatherEntity ->
                CurrentCityWeather(
                    base = cityWeatherEntity.base,
                    clouds = cityWeatherEntity.currentCloudsEntity.toClouds(),
                    cod = cityWeatherEntity.cod,
                    coord = cityWeatherEntity.currentCoordEntity.toCoord(),
                    dt = cityWeatherEntity.dt,
                    id = cityWeatherEntity.id,
                    main = cityWeatherEntity.currentMainEntity.toMain(),
                    name = cityWeatherEntity.name,
                    sys = cityWeatherEntity.currentSysEntity.toSys(),
                    timezone = cityWeatherEntity.timezone,
                    visibility = cityWeatherEntity.visibility,
                    weather = cityWeatherEntity.currentWeatherEntity.map { weatherEntity -> weatherEntity.toWeather() },
                    wind = cityWeatherEntity.currentWindEntity.toWind(),
                    lastUpdated = cityWeatherEntity.lastUpdated,
                )
            }
        }
    }

    override suspend fun getForecastCityWeather(city: String): Flow<ForecastCityWeather> {
        return withContext(context = dispatcher) {
            homeLocalSource.getForecastCityWeather(city = city).map { forecastCityWeatherEntity ->
                ForecastCityWeather(
                    forecastCity = forecastCityWeatherEntity.forecastCityEntity.toForecastCity(),
                    cnt = forecastCityWeatherEntity.cnt,
                    cod = forecastCityWeatherEntity.cod,
                    list = forecastCityWeatherEntity.list.map { forecastCityWeatherEntityList ->
                        forecastCityWeatherEntityList.toForecastWeatherItem() },
                    message = forecastCityWeatherEntity.message,
                )
            }
        }
    }
}