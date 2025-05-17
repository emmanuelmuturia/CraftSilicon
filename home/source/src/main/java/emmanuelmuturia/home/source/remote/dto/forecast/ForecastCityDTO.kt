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

import emmanuelmuturia.home.source.local.entity.forecast.ForecastCityEntity
import emmanuelmuturia.home.source.local.entity.forecast.ForecastCoordEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastCityDTO(
    @SerialName("coord")
    val forecastCoordDTO: emmanuelmuturia.home.source.remote.dto.forecast.ForecastCoordDTO,
    @SerialName("country")
    val country: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("population")
    val population: Int,
    @SerialName("sunrise")
    val sunrise: Int,
    @SerialName("sunset")
    val sunset: Int,
    @SerialName("timezone")
    val timezone: Int,
) {
    fun toForecastCityEntity(): emmanuelmuturia.home.source.local.entity.forecast.ForecastCityEntity {
        return emmanuelmuturia.home.source.local.entity.forecast.ForecastCityEntity(
            forecastCoordEntity =
                emmanuelmuturia.home.source.local.entity.forecast.ForecastCoordEntity(
                    lat = forecastCoordDTO.lat,
                    lon = forecastCoordDTO.lon,
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
}