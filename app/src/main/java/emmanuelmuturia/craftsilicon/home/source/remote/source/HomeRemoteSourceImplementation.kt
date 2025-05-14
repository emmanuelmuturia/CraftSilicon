package emmanuelmuturia.craftsilicon.home.source.remote.source

import emmanuelmuturia.craftsilicon.commons.state.CraftSiliconNetworkResult
import emmanuelmuturia.craftsilicon.home.source.remote.api.OpenWeatherAPI
import emmanuelmuturia.craftsilicon.home.source.remote.dto.CityWeatherDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class HomeRemoteSourceImplementation(
    private val openWeatherAPI: OpenWeatherAPI,
    private val dispatcher: CoroutineDispatcher,
): HomeRemoteSource {
    override suspend fun getCityWeather(city: String): CraftSiliconNetworkResult<CityWeatherDTO> {
        return withContext(context = dispatcher) {
            try {
                val response = openWeatherAPI.getWeather(city = city)
                if (response.isSuccessful) {
                    CraftSiliconNetworkResult.Success(data = response.body()!!)
                } else {
                    CraftSiliconNetworkResult.Error(response.errorBody().toString())
                }
            } catch (e: Exception) {
                CraftSiliconNetworkResult.Error(error = e.message ?: "Unknown Error")
            }
        }
    }
}