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
package emmanuelmuturia.home.data.model.forecast

import emmanuelmuturia.home.source.local.entity.forecast.ForecastWeatherItemEntity

data class ForecastWeatherItem(
    val forecastClouds: ForecastClouds,
    val dt: Int,
    val dtTxt: String,
    val forecastMain: ForecastMain,
    val pop: Double,
    val forecastRain: ForecastRain,
    val forecastSys: ForecastSys,
    val visibility: Int,
    val forecastWeather: List<ForecastWeather>,
    val forecastWind: ForecastWind,
    val lastUpdated: String,
)

fun ForecastWeatherItemEntity.toForecastWeatherItem(): ForecastWeatherItem {
    return ForecastWeatherItem(
        forecastClouds =
            ForecastClouds(
                all = forecastCloudsEntity.all,
            ),
        dt = dt,
        dtTxt = dtTxt,
        forecastMain =
            ForecastMain(
                feelsLike = forecastMainEntity.feelsLike,
                grndLevel = forecastMainEntity.grndLevel,
                humidity = forecastMainEntity.humidity,
                pressure = forecastMainEntity.pressure,
                seaLevel = forecastMainEntity.seaLevel,
                temp = forecastMainEntity.temp,
                tempKf = forecastMainEntity.tempKf,
                tempMax = forecastMainEntity.tempMax,
                tempMin = forecastMainEntity.tempMin,
            ),
        pop = pop,
        forecastRain =
            ForecastRain(
                h = forecastRainEntity.h,
            ),
        forecastSys =
            ForecastSys(
                pod = forecastSysEntity.pod,
            ),
        visibility = visibility,
        forecastWeather =
            forecastWeatherEntity.map { forecastWeatherEntity ->
                ForecastWeather(
                    description = forecastWeatherEntity.description,
                    icon = forecastWeatherEntity.icon,
                    id = forecastWeatherEntity.id,
                    main = forecastWeatherEntity.main,
                )
            },
        forecastWind =
            ForecastWind(
                deg = forecastWindEntity.deg,
                gust = forecastWindEntity.gust,
                speed = forecastWindEntity.speed,
            ),
        lastUpdated = lastUpdated,
    )
}