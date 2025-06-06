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
package emmanuelmuturia.home.source.local.entity.current

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CurrentCityWeatherEntity")
data class CurrentCityWeatherEntity(
    @PrimaryKey
    val currentCityWeatherId: Int = 0,
    @ColumnInfo(name = "base")
    val base: String,
    @Embedded(prefix = "clouds_")
    val currentCloudsEntity: CurrentCloudsEntity,
    @ColumnInfo(name = "cod")
    val cod: Int,
    @Embedded(prefix = "coord_")
    val currentCoordEntity: CurrentCoordEntity,
    @ColumnInfo(name = "dt")
    val dt: Int,
    @ColumnInfo(name = "id")
    val id: Int,
    @Embedded(prefix = "main_")
    val currentMainEntity: CurrentMainEntity,
    @ColumnInfo(name = "name")
    val name: String,
    @Embedded(prefix = "sys_")
    val currentSysEntity: CurrentSysEntity,
    @ColumnInfo(name = "timezone")
    val timezone: Int,
    @ColumnInfo(name = "visibility")
    val visibility: Int,
    val currentWeatherEntity: List<CurrentWeatherEntity>,
    @Embedded(prefix = "wind_")
    val currentWindEntity: CurrentWindEntity,
    @ColumnInfo(name = "lastUpdated")
    val lastUpdated: String,
)