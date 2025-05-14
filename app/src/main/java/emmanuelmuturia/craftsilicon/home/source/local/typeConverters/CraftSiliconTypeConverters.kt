package emmanuelmuturia.craftsilicon.home.source.local.typeConverters

import androidx.room.TypeConverter
import emmanuelmuturia.craftsilicon.home.source.local.entity.WeatherEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CraftSiliconTypeConverters {

    @TypeConverter
    fun convertWeatherEntitiesToString(weatherEntities: List<WeatherEntity>): String {
        return Json.encodeToString(value = weatherEntities)
    }

    @TypeConverter
    fun convertStringToWeatherEntities(weatherEntitiesString: String): List<WeatherEntity> {
        return Json.decodeFromString(string = weatherEntitiesString)
    }

}