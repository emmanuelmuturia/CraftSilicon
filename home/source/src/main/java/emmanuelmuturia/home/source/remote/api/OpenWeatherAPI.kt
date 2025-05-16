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
package emmanuelmuturia.home.source.remote.api

import emmanuelmuturia.home.source.BuildConfig
import emmanuelmuturia.home.source.remote.dto.current.CurrentCityWeatherDTO
import emmanuelmuturia.home.source.remote.dto.forecast.ForecastCityWeatherDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("APPID") appId: String = BuildConfig.apiKey,
    ): Response<CurrentCityWeatherDTO>

    @GET("data/2.5/forecast")
    suspend fun getForecastWeather(
        @Query("q") cityName: String,
        @Query("cnt") count: Int = 5,
        @Query("appid") appId: String = BuildConfig.apiKey,
    ): Response<ForecastCityWeatherDTO>
}