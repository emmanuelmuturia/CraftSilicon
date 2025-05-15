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
package emmanuelmuturia.craftsilicon.home.source.local.typeConverters

import androidx.room.TypeConverter
import emmanuelmuturia.craftsilicon.home.source.local.entity.CloudsEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.CoordEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.MainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.SysEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.WeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.WindEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CraftSiliconTypeConverters {
    @TypeConverter
    fun convertCloudsEntityToString(cloudsEntity: CloudsEntity): String {
        return Json.encodeToString(value = cloudsEntity)
    }

    @TypeConverter
    fun convertStringToCloudsEntity(cloudsEntityString: String): CloudsEntity {
        return Json.decodeFromString(string = cloudsEntityString)
    }

    @TypeConverter
    fun convertCoordEntityToString(coordEntity: CoordEntity): String {
        return Json.encodeToString(value = coordEntity)
    }

    @TypeConverter
    fun convertStringToCoordEntity(coordEntityString: String): CoordEntity {
        return Json.decodeFromString(string = coordEntityString)
    }

    @TypeConverter
    fun convertMainEntityToString(mainEntity: MainEntity): String {
        return Json.encodeToString(value = mainEntity)
    }

    @TypeConverter
    fun convertStringToMainEntity(mainEntityString: String): MainEntity {
        return Json.decodeFromString(string = mainEntityString)
    }

    @TypeConverter
    fun convertSysEntityToString(sysEntity: SysEntity): String {
        return Json.encodeToString(value = sysEntity)
    }

    @TypeConverter
    fun convertStringToSysEntity(sysEntityString: String): SysEntity {
        return Json.decodeFromString(string = sysEntityString)
    }

    @TypeConverter
    fun convertWindEntityToString(windEntity: WindEntity): String {
        return Json.encodeToString(value = windEntity)
    }

    @TypeConverter
    fun convertStringToWindEntity(windEntityString: String): WindEntity {
        return Json.decodeFromString(string = windEntityString)
    }

    @TypeConverter
    fun convertWeatherEntitiesToString(weatherEntities: List<WeatherEntity>): String {
        return Json.encodeToString(value = weatherEntities)
    }

    @TypeConverter
    fun convertStringToWeatherEntities(weatherEntitiesString: String): List<WeatherEntity> {
        return Json.decodeFromString(string = weatherEntitiesString)
    }
}