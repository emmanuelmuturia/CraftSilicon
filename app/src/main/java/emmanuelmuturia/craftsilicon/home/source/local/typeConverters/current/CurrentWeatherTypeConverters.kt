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
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentCloudsEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentCoordEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentMainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentSysEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentWindEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CurrentWeatherTypeConverters {
    @TypeConverter
    fun convertCloudsEntityToString(currentCloudsEntity: CurrentCloudsEntity): String {
        return Json.encodeToString(value = currentCloudsEntity)
    }

    @TypeConverter
    fun convertStringToCloudsEntity(cloudsEntityString: String): CurrentCloudsEntity {
        return Json.decodeFromString(string = cloudsEntityString)
    }

    @TypeConverter
    fun convertCoordEntityToString(currentCoordEntity: CurrentCoordEntity): String {
        return Json.encodeToString(value = currentCoordEntity)
    }

    @TypeConverter
    fun convertStringToCoordEntity(coordEntityString: String): CurrentCoordEntity {
        return Json.decodeFromString(string = coordEntityString)
    }

    @TypeConverter
    fun convertMainEntityToString(currentMainEntity: CurrentMainEntity): String {
        return Json.encodeToString(value = currentMainEntity)
    }

    @TypeConverter
    fun convertStringToMainEntity(mainEntityString: String): CurrentMainEntity {
        return Json.decodeFromString(string = mainEntityString)
    }

    @TypeConverter
    fun convertSysEntityToString(currentSysEntity: CurrentSysEntity): String {
        return Json.encodeToString(value = currentSysEntity)
    }

    @TypeConverter
    fun convertStringToSysEntity(sysEntityString: String): CurrentSysEntity {
        return Json.decodeFromString(string = sysEntityString)
    }

    @TypeConverter
    fun convertWindEntityToString(currentWindEntity: CurrentWindEntity): String {
        return Json.encodeToString(value = currentWindEntity)
    }

    @TypeConverter
    fun convertStringToWindEntity(windEntityString: String): CurrentWindEntity {
        return Json.decodeFromString(string = windEntityString)
    }

    @TypeConverter
    fun convertWeatherEntitiesToString(weatherEntities: List<CurrentWeatherEntity>): String {
        return Json.encodeToString(value = weatherEntities)
    }

    @TypeConverter
    fun convertStringToWeatherEntities(weatherEntitiesString: String): List<CurrentWeatherEntity> {
        return Json.decodeFromString(string = weatherEntitiesString)
    }
}