package emmanuelmuturia.craftsilicon.home.data.repository

import emmanuelmuturia.craftsilicon.home.data.model.CityWeather
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getCityWeather(city: String): Flow<CityWeather>
}