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
package emmanuelmuturia.craftsilicon.home.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import emmanuelmuturia.craftsilicon.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentCityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentCloudsEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentCoordEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentMainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentSysEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentWindEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCityEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCloudsEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCoordEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastMainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastRainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastSysEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWeatherItemEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWindEntity
import emmanuelmuturia.craftsilicon.home.source.local.typeConverters.current.CurrentWeatherTypeConverters
import emmanuelmuturia.craftsilicon.home.source.local.typeConverters.forecast.ForecastWeatherTypeConverters

@Database(
    entities = [
        CurrentCityWeatherEntity::class,
        ForecastCityWeatherEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(value = [CurrentWeatherTypeConverters::class, ForecastWeatherTypeConverters::class])
abstract class CraftSiliconDatabase : RoomDatabase() {
    abstract fun craftSiliconDao(): CraftSiliconDao
}