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
package emmanuelmuturia.craftsilicon.home.source.remote.source

import emmanuelmuturia.craftsilicon.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.craftsilicon.home.source.local.entity.CityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.remote.api.OpenWeatherAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class HomeRemoteSourceImplementation(
    private val openWeatherAPI: OpenWeatherAPI,
    private val dispatcher: CoroutineDispatcher,
    private val craftSiliconDao: CraftSiliconDao,
) : HomeRemoteSource {
    override suspend fun getCityWeather(city: String) {
        withContext(context = dispatcher) {
            val response = openWeatherAPI.getWeather(city = city)
            if (response.isSuccessful) {
                craftSiliconDao.insertCityWeather(
                    cityWeatherEntity =
                        CityWeatherEntity(
                            base = response.body()!!.base,
                            cloudsEntity = response.body()!!.currentCloudsDTO.toCloudsEntity(),
                            cod = response.body()!!.cod,
                            coordEntity = response.body()!!.currentCoordDTO.toCoordEntity(),
                            dt = response.body()!!.dt,
                            id = response.body()!!.id,
                            mainEntity = response.body()!!.currentMainDTO.toMainEntity(),
                            name = response.body()!!.name,
                            sysEntity = response.body()!!.currentSysDTO.toSysEntity(),
                            timezone = response.body()!!.timezone,
                            visibility = response.body()!!.visibility,
                            weatherEntity = response.body()!!.currentWeatherDTO.map { weatherDTO -> weatherDTO.toWeatherEntity() },
                            windEntity = response.body()!!.currentWindDTO.toWindEntity(),
                            lastUpdated = System.currentTimeMillis(),
                        ),
                )
            }
        }
    }
}