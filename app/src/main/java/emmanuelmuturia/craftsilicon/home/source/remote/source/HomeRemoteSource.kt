package emmanuelmuturia.craftsilicon.home.source.remote.source

import emmanuelmuturia.craftsilicon.commons.state.CraftSiliconNetworkResult
import emmanuelmuturia.craftsilicon.home.source.remote.dto.CityWeatherDTO

interface HomeRemoteSource {
    suspend fun getCityWeather(city: String): CraftSiliconNetworkResult<CityWeatherDTO>
}