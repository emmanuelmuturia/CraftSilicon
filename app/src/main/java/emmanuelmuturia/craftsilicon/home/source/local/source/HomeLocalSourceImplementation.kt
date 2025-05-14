package emmanuelmuturia.craftsilicon.home.source.local.source

import emmanuelmuturia.craftsilicon.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.craftsilicon.home.source.local.entity.CityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.remote.source.HomeRemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class HomeLocalSourceImplementation(
    private val craftSiliconDao: CraftSiliconDao,
    private val dispatcher: CoroutineDispatcher,
    private val homeRemoteSource: HomeRemoteSource
): HomeLocalSource {
    override suspend fun getCityWeather(city: String): Flow<CityWeatherEntity> {
        return withContext(context = dispatcher) {
            craftSiliconDao.getCityWeather().map { cityWeatherEntity ->
                CityWeatherEntity(
                    base = cityWeatherEntity.base,
                    cloudsEntity = cityWeatherEntity.cloudsEntity,
                    cod = cityWeatherEntity.cod,
                    coordEntity = cityWeatherEntity.coordEntity,
                    dt = cityWeatherEntity.dt,
                    id = cityWeatherEntity.id,
                    mainEntity = cityWeatherEntity.mainEntity,
                    name = cityWeatherEntity.name,
                    sysEntity = cityWeatherEntity.sysEntity,
                    timezone = cityWeatherEntity.timezone,
                    visibility = cityWeatherEntity.visibility,
                    weatherEntity = cityWeatherEntity.weatherEntity,
                    windEntity = cityWeatherEntity.windEntity
                )
            }
        }.onEach {
            if (it == null) {
                homeRemoteSource.getCityWeather(city = city)
            }
        }
    }
}