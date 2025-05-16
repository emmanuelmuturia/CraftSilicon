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

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ForecastCityWeatherEntity")
data class ForecastCityWeatherEntity(
    @PrimaryKey
    val forecastCityWeatherId: Int = 0,
    @Embedded(prefix = "city_")
    val forecastCityEntity: emmanuelmuturia.home.source.local.entity.forecast.ForecastCityEntity,
    @ColumnInfo(name = "cnt")
    val cnt: Int,
    @ColumnInfo(name = "cod")
    val cod: String,
    val list: List<emmanuelmuturia.home.source.local.entity.forecast.ForecastWeatherItemEntity>,
    @ColumnInfo(name = "message")
    val message: Int,
)