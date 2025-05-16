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
package emmanuelmuturia.home.source.local.entity.forecast

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class ForecastWeatherItemEntity(
    @Embedded(prefix = "forecast_clouds_")
    val forecastCloudsEntity: emmanuelmuturia.home.source.local.entity.forecast.ForecastCloudsEntity,
    val dt: Int,
    val dtTxt: String,
    @Embedded(prefix = "forecast_main_")
    val forecastMainEntity: emmanuelmuturia.home.source.local.entity.forecast.ForecastMainEntity,
    val pop: Double,
    @Embedded(prefix = "forecast_rain_")
    val forecastRainEntity: emmanuelmuturia.home.source.local.entity.forecast.ForecastRainEntity,
    @Embedded(prefix = "forecast_sys_")
    val forecastSysEntity: emmanuelmuturia.home.source.local.entity.forecast.ForecastSysEntity,
    val visibility: Int,
    val forecastWeatherEntity: List<emmanuelmuturia.home.source.local.entity.forecast.ForecastWeatherEntity>,
    @Embedded(prefix = "forecast_wind_")
    val forecastWindEntity: emmanuelmuturia.home.source.local.entity.forecast.ForecastWindEntity,
)