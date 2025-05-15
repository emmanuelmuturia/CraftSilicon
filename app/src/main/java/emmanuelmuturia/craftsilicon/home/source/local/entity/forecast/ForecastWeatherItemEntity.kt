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
package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ForecastWeatherItemEntity")
data class ForecastWeatherItemEntity(
    @PrimaryKey
    @ColumnInfo(name = "clouds")
    val forecastCloudsEntity: ForecastCloudsEntity,
    @ColumnInfo(name = "dt")
    val dt: Int,
    @ColumnInfo(name = "dt_txt")
    val dtTxt: String,
    @ColumnInfo(name = "main")
    val forecastMainEntity: ForecastMainEntity,
    @ColumnInfo(name = "pop")
    val pop: Double,
    @ColumnInfo(name = "rain")
    val forecastRainEntity: ForecastRainEntity,
    @ColumnInfo(name = "sys")
    val forecastSysEntity: ForecastSysEntity,
    @ColumnInfo(name = "visibility")
    val visibility: Int,
    @ColumnInfo(name = "weather")
    val forecastWeatherEntity: List<ForecastWeatherEntity>,
    @ColumnInfo(name = "wind")
    val forecastWindEntity: ForecastWindEntity,
)