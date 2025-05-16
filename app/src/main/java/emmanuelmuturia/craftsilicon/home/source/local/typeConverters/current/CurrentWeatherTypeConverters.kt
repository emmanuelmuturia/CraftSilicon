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
package emmanuelmuturia.craftsilicon.home.source.local.typeConverters.current

import androidx.room.TypeConverter
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentWeatherEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CurrentWeatherTypeConverters {
    private val json =
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = true
            prettyPrint = true
        }

    @TypeConverter
    fun convertWeatherEntitiesToString(weatherEntities: List<CurrentWeatherEntity>): String {
        return json.encodeToString(value = weatherEntities)
    }

    @TypeConverter
    fun convertStringToWeatherEntities(weatherEntitiesString: String): List<CurrentWeatherEntity> {
        return json.decodeFromString(string = weatherEntitiesString)
    }
}