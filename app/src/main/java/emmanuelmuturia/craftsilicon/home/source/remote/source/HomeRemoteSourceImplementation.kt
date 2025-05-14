package emmanuelmuturia.craftsilicon.home.source.remote.source

import emmanuelmuturia.craftsilicon.commons.state.CraftSiliconNetworkResult
import emmanuelmuturia.craftsilicon.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.craftsilicon.home.source.local.entity.CityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.source.HomeLocalSource
import emmanuelmuturia.craftsilicon.home.source.remote.api.OpenWeatherAPI
import emmanuelmuturia.craftsilicon.home.source.remote.dto.CityWeatherDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class HomeRemoteSourceImplementation(
    private val openWeatherAPI: OpenWeatherAPI,
    private val dispatcher: CoroutineDispatcher,
    private val craftSiliconDao: CraftSiliconDao
): HomeRemoteSource {
    override suspend fun getCityWeather(city: String) {
        withContext(context = dispatcher) {
            val response = openWeatherAPI.getWeather(city = city)
            if (response.isSuccessful) {
                craftSiliconDao.insertCityWeather(cityWeatherEntity = CityWeatherEntity(
                    base = response.body()!!.base,
                    cloudsEntity = response.body()!!.cloudsDTO.toCloudsEntity(),
                    cod = response.body()!!.cod,
                    coordEntity = response.body()!!.coordDTO.toCoordEntity(),
                    dt = response.body()!!.dt,
                    id = response.body()!!.id,
                    mainEntity = response.body()!!.mainDTO.toMainEntity(),
                    name = response.body()!!.name,
                    sysEntity = response.body()!!.sysDTO.toSysEntity(),
                    timezone = response.body()!!.timezone,
                    visibility = response.body()!!.visibility,
                    weatherEntity = response.body()!!.weatherDTO.map { weatherDTO -> weatherDTO.toWeatherEntity() },
                    windEntity = response.body()!!.windDTO.toWindEntity()
                ))
            }
        }
    }
}