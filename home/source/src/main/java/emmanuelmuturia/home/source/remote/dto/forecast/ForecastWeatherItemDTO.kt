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
package emmanuelmuturia.home.source.remote.dto.forecast

import emmanuelmuturia.home.source.local.entity.forecast.ForecastCloudsEntity
import emmanuelmuturia.home.source.local.entity.forecast.ForecastMainEntity
import emmanuelmuturia.home.source.local.entity.forecast.ForecastRainEntity
import emmanuelmuturia.home.source.local.entity.forecast.ForecastSysEntity
import emmanuelmuturia.home.source.local.entity.forecast.ForecastWeatherEntity
import emmanuelmuturia.home.source.local.entity.forecast.ForecastWindEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastWeatherItemDTO(
    @SerialName("clouds")
    val forecastCloudsDTO: ForecastCloudsDTO,
    @SerialName("dt")
    val dt: Int,
    @SerialName("dt_txt")
    val dtTxt: String,
    @SerialName("main")
    val forecastMainDTO: ForecastMainDTO,
    @SerialName("pop")
    val pop: Double,
    @SerialName("rain")
    val forecastRainDTO: ForecastRainDTO? = null,
    @SerialName("sys")
    val forecastSysDTO: ForecastSysDTO,
    @SerialName("visibility")
    val visibility: Int,
    @SerialName("weather")
    val forecastWeatherDTO: List<ForecastWeatherDTO>,
    @SerialName("wind")
    val forecastWindDTO: ForecastWindDTO,
) {
    fun toForecastWeatherItemEntity(): emmanuelmuturia.home.source.local.entity.forecast.ForecastWeatherItemEntity {
        return emmanuelmuturia.home.source.local.entity.forecast.ForecastWeatherItemEntity(
            forecastCloudsEntity =
                ForecastCloudsEntity(
                    all = forecastCloudsDTO.all,
                ),
            dt = dt,
            dtTxt = dtTxt,
            forecastMainEntity =
                ForecastMainEntity(
                    feelsLike = forecastMainDTO.feelsLike,
                    grndLevel = forecastMainDTO.grndLevel,
                    humidity = forecastMainDTO.humidity,
                    pressure = forecastMainDTO.pressure,
                    seaLevel = forecastMainDTO.seaLevel,
                    temp = forecastMainDTO.temp,
                    tempKf = forecastMainDTO.tempKf,
                    tempMax = forecastMainDTO.tempMax,
                    tempMin = forecastMainDTO.tempMin,
                ),
            pop = pop,
            forecastRainEntity =
                ForecastRainEntity(
                    h = forecastRainDTO?.h ?: 0.0,
                ),
            forecastSysEntity =
                ForecastSysEntity(
                    pod = forecastSysDTO.pod,
                ),
            visibility = visibility,
            forecastWeatherEntity =
                listOf(
                    ForecastWeatherEntity(
                        description = forecastWeatherDTO.first().description,
                        icon = forecastWeatherDTO.first().icon,
                        id = forecastWeatherDTO.first().id,
                        main = forecastWeatherDTO.first().main,
                    ),
                ),
            forecastWindEntity =
                ForecastWindEntity(
                    deg = forecastWindDTO.deg,
                    gust = forecastWindDTO.gust,
                    speed = forecastWindDTO.speed,
                ),
        )
    }
}