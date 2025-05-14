package emmanuelmuturia.craftsilicon.home.source.local.source

import emmanuelmuturia.craftsilicon.home.source.local.entity.CityWeatherEntity
import kotlinx.coroutines.flow.Flow

interface HomeLocalSource {
    suspend fun getCityWeather(city: String): Flow<CityWeatherEntity>
}