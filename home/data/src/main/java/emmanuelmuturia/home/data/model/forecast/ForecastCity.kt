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

import emmanuelmuturia.home.source.local.entity.forecast.ForecastCityEntity


data class ForecastCity(
    val forecastCoord: ForecastCoord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int,
)

fun ForecastCityEntity.toForecastCity(): ForecastCity {
    return ForecastCity(
        forecastCoord =
            ForecastCoord(
                lat = forecastCoordEntity.lat,
                lon = forecastCoordEntity.lon,
            ),
        country = country,
        id = id,
        name = name,
        population = population,
        sunrise = sunrise,
        sunset = sunset,
        timezone = timezone,
    )
}