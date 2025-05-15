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
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCityEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCloudsEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCoordEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastMainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastRainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastSysEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWeatherItemEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWindEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ForecastWeatherTypeConverters {
    @TypeConverter
    fun convertCoordEntityToString(forecastCoordEntity: ForecastCoordEntity): String {
        return Json.encodeToString(value = forecastCoordEntity)
    }

    @TypeConverter
    fun convertStringToCoordEntity(coordEntityString: String): ForecastCoordEntity {
        return Json.decodeFromString(string = coordEntityString)
    }

    @TypeConverter
    fun convertForecastCityEntityToString(forecastCityEntity: ForecastCityEntity): String {
        return Json.encodeToString(value = forecastCityEntity)
    }

    @TypeConverter
    fun convertStringToForecastCityEntity(cityString: String): ForecastCityEntity {
        return Json.decodeFromString(string = cityString)
    }

    @TypeConverter
    fun convertForecastWeatherListToString(weatherList: List<ForecastWeatherItemEntity>): String {
        return Json.encodeToString(value = weatherList)
    }

    @TypeConverter
    fun convertStringToForecastWeatherList(weatherListString: String): List<ForecastWeatherItemEntity> {
        return Json.decodeFromString(string = weatherListString)
    }

    @TypeConverter
    fun convertCloudsEntityToString(forecastCloudsEntity: ForecastCloudsEntity): String {
        return Json.encodeToString(value = forecastCloudsEntity)
    }

    @TypeConverter
    fun convertStringToCloudsEntity(cloudsEntityString: String): ForecastCloudsEntity {
        return Json.decodeFromString(string = cloudsEntityString)
    }

    @TypeConverter
    fun convertMainEntityToString(forecastMainEntity: ForecastMainEntity): String {
        return Json.encodeToString(value = forecastMainEntity)
    }

    @TypeConverter
    fun convertStringToMainEntity(mainEntityString: String): ForecastMainEntity {
        return Json.decodeFromString(string = mainEntityString)
    }

    @TypeConverter
    fun convertRainEntityToString(forecastRainEntity: ForecastRainEntity): String {
        return Json.encodeToString(value = forecastRainEntity)
    }

    @TypeConverter
    fun convertStringToRainEntity(rainEntityString: String): ForecastRainEntity {
        return Json.decodeFromString(string = rainEntityString)
    }

    @TypeConverter
    fun convertSysEntityToString(forecastSysEntity: ForecastSysEntity): String {
        return Json.encodeToString(value = forecastSysEntity)
    }

    @TypeConverter
    fun convertStringToSysEntity(sysEntityString: String): ForecastSysEntity {
        return Json.decodeFromString(string = sysEntityString)
    }

    @TypeConverter
    fun convertWeatherListToString(forecastWeatherEntityList: List<ForecastWeatherEntity>): String {
        return Json.encodeToString(value = forecastWeatherEntityList)
    }

    @TypeConverter
    fun convertStringToWeatherList(weatherListString: String): List<ForecastWeatherEntity> {
        return Json.decodeFromString(string = weatherListString)
    }

    @TypeConverter
    fun convertWindEntityToString(forecastWindEntity: ForecastWindEntity): String {
        return Json.encodeToString(value = forecastWindEntity)
    }

    @TypeConverter
    fun convertStringToWindEntity(windEntityString: String): ForecastWindEntity {
        return Json.decodeFromString(string = windEntityString)
    }
}