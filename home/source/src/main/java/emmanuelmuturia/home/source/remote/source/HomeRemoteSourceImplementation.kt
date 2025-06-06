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
package emmanuelmuturia.home.source.remote.source

import emmanuelmuturia.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.home.source.local.entity.current.CurrentCityWeatherEntity
import emmanuelmuturia.home.source.local.entity.forecast.ForecastCityWeatherEntity
import emmanuelmuturia.home.source.remote.api.OpenWeatherAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * This is the implementation of the Remote Data Source for the :home module...
 */

class HomeRemoteSourceImplementation(
    private val openWeatherAPI: OpenWeatherAPI,
    private val dispatcher: CoroutineDispatcher,
    private val craftSiliconDao: CraftSiliconDao,
) : HomeRemoteSource {
    override suspend fun getCurrentWeather(cityName: String) {
        withContext(context = dispatcher) {
            val response = openWeatherAPI.getCurrentWeather(cityName = cityName)
            if (response.isSuccessful) {
                craftSiliconDao.insertCurrentWeather(
                    currentCityWeatherEntity =
                        CurrentCityWeatherEntity(
                            base = response.body()!!.base,
                            currentCloudsEntity = response.body()!!.currentCloudsDTO.toCloudsEntity(),
                            cod = response.body()!!.cod,
                            currentCoordEntity = response.body()!!.currentCoordDTO.toCoordEntity(),
                            dt = response.body()!!.dt,
                            id = response.body()!!.id,
                            currentMainEntity = response.body()!!.currentMainDTO.toMainEntity(),
                            name = response.body()!!.name,
                            currentSysEntity = response.body()!!.currentSysDTO.toSysEntity(),
                            timezone = response.body()!!.timezone,
                            visibility = response.body()!!.visibility,
                            currentWeatherEntity = response.body()!!.currentWeatherDTO.map { weatherDTO -> weatherDTO.toWeatherEntity() },
                            currentWindEntity = response.body()!!.currentWindDTO.toWindEntity(),
                            lastUpdated = formatLastUpdatedTime(lastUpdatedTime = System.currentTimeMillis()),
                        ),
                )
            }
        }
    }

    override suspend fun getForecastWeather(cityName: String) {
        withContext(context = dispatcher) {
            val response = openWeatherAPI.getForecastWeather(cityName = cityName)
            if (response.isSuccessful) {
                craftSiliconDao.insertForecastWeather(
                    forecastCityWeatherEntity =
                        ForecastCityWeatherEntity(
                            forecastCityEntity = response.body()!!.forecastCityDTO.toForecastCityEntity(),
                            cnt = response.body()!!.cnt,
                            cod = response.body()!!.cod,
                            list =
                                response.body()!!.list.map { forecastWeatherItemDTO ->
                                    forecastWeatherItemDTO.toForecastWeatherItemEntity()
                                },
                            message = response.body()!!.message,
                        ),
                )
            }
        }
    }
}

private fun formatLastUpdatedTime(lastUpdatedTime: Long): String {
    val date = Date(lastUpdatedTime)
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    return formatter.format(date)
}