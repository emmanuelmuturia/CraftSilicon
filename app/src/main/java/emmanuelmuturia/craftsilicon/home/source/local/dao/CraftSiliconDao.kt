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
package emmanuelmuturia.craftsilicon.home.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentCityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCityWeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CraftSiliconDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentWeather(currentCityWeatherEntity: CurrentCityWeatherEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecastWeather(forecastCityWeatherEntity: ForecastCityWeatherEntity)

    @Query(value = "SELECT * FROM CurrentCityWeatherEntity")
    fun getCurrentWeather(): Flow<CurrentCityWeatherEntity?>

    @Query(value = "SELECT * FROM ForecastCityWeatherEntity")
    fun getForecastWeather(): Flow<ForecastCityWeatherEntity?>
}