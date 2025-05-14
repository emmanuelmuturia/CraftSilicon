package emmanuelmuturia.craftsilicon.home.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import emmanuelmuturia.craftsilicon.home.source.local.entity.CityWeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CraftSiliconDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCityWeather(cityWeatherEntity: CityWeatherEntity)

    @Query(value = "SELECT * FROM CityWeatherEntity")
    fun getCityWeather(): Flow<CityWeatherEntity>

}