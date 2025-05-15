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

@Entity(tableName = "ForecastMainEntity")
data class ForecastMainEntity(
    @PrimaryKey
    @ColumnInfo(name = "feels_like")
    val feelsLike: Double,
    @ColumnInfo(name = "grnd_level")
    val grndLevel: Int,
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    @ColumnInfo(name = "pressure")
    val pressure: Int,
    @ColumnInfo(name = "sea_level")
    val seaLevel: Int,
    @ColumnInfo(name = "temp")
    val temp: Double,
    @ColumnInfo(name = "temp_kf")
    val tempKf: Double,
    @ColumnInfo(name = "temp_max")
    val tempMax: Double,
    @ColumnInfo(name = "temp_min")
    val tempMin: Double,
)