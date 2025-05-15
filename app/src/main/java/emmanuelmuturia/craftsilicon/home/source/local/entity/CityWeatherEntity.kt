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
package emmanuelmuturia.craftsilicon.home.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CityWeatherEntity")
data class CityWeatherEntity(
    @ColumnInfo(name = "base")
    val base: String,
    @ColumnInfo(name = "clouds")
    val cloudsEntity: CloudsEntity,
    @ColumnInfo(name = "cod")
    val cod: Int,
    @ColumnInfo(name = "coord")
    val coordEntity: CoordEntity,
    @ColumnInfo(name = "dt")
    val dt: Int,
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "main")
    val mainEntity: MainEntity,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "sys")
    val sysEntity: SysEntity,
    @ColumnInfo(name = "timezone")
    val timezone: Int,
    @ColumnInfo(name = "visibility")
    val visibility: Int,
    @ColumnInfo(name = "weather")
    val weatherEntity: List<WeatherEntity>,
    @ColumnInfo(name = "wind")
    val windEntity: WindEntity,
    @ColumnInfo(name = "lastUpdated")
    val lastUpdated: Long,
)