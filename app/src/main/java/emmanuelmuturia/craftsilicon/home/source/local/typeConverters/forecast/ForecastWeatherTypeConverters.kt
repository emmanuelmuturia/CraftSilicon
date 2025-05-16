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
package emmanuelmuturia.craftsilicon.home.source.local.typeConverters.forecast

import androidx.room.TypeConverter
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWeatherItemEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ForecastWeatherTypeConverters {
    private val json =
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = true
            prettyPrint = true
        }

    @TypeConverter
    fun convertForecastWeatherListToString(forecastWeatherItemEntities: List<ForecastWeatherItemEntity>): String {
        return json.encodeToString(value = forecastWeatherItemEntities)
    }

    @TypeConverter
    fun convertStringToForecastWeatherList(forecastWeatherItems: String): List<ForecastWeatherItemEntity> {
        return json.decodeFromString(string = forecastWeatherItems)
    }

    @TypeConverter
    fun convertWeatherListToString(forecastWeatherEntityList: List<ForecastWeatherEntity>): String {
        return json.encodeToString(value = forecastWeatherEntityList)
    }

    @TypeConverter
    fun convertStringToWeatherList(weatherListString: String): List<ForecastWeatherEntity> {
        return json.decodeFromString(string = weatherListString)
    }
}