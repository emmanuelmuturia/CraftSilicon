package emmanuelmuturia.home.source.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import emmanuelmuturia.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.home.source.local.database.CraftSiliconDatabase
import emmanuelmuturia.home.source.local.entity.current.CurrentCityWeatherEntity
import emmanuelmuturia.home.source.local.entity.current.CurrentCloudsEntity
import emmanuelmuturia.home.source.local.entity.current.CurrentCoordEntity
import emmanuelmuturia.home.source.local.entity.current.CurrentMainEntity
import emmanuelmuturia.home.source.local.entity.current.CurrentSysEntity
import emmanuelmuturia.home.source.local.entity.current.CurrentWeatherEntity
import emmanuelmuturia.home.source.local.entity.current.CurrentWindEntity
import emmanuelmuturia.home.source.local.entity.forecast.ForecastCityWeatherEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = AndroidJUnit4::class)
class CraftSiliconDaoTest {

    private lateinit var craftSiliconDatabase: CraftSiliconDatabase
    private lateinit var craftSiliconDao: CraftSiliconDao

    @Before
    fun createDatabase() {
        craftSiliconDatabase = Room.inMemoryDatabaseBuilder(
            context = ApplicationProvider.getApplicationContext(),
            klass = CraftSiliconDatabase::class.java,
        ).allowMainThreadQueries().build()
        craftSiliconDao = craftSiliconDatabase.craftSiliconDao()
    }

    @After
    fun closeDatabase() {
        craftSiliconDatabase.close()
    }

    @Test
    fun testInsertAndGetCurrentWeather() = runTest {
        // Given the Current City Weather...
        val currentCityWeatherEntity = CurrentCityWeatherEntity(
            base = "base",
            cod = 1,
            dt = 1,
            id = 1,
            name = "name",
            timezone = 1,
            visibility = 1,
            lastUpdated = 1L,
            currentWeatherEntity = listOf(
                CurrentWeatherEntity(
                    description = "description",
                    icon = "icon",
                    id = 1,
                    main = "main",
                )
            ),
            currentCoordEntity = CurrentCoordEntity(
                lat = 1.0,
                lon = 1.0,
            ),
            currentCloudsEntity = CurrentCloudsEntity(
                all = 1,
            ),
            currentMainEntity = CurrentMainEntity(
                feelsLike = 1.0,
                grndLevel = 1,
                humidity = 1,
                pressure = 1,
                seaLevel = 1,
                temp = 1.0,
                tempMax = 1.0,
                tempMin = 1.0,
            ),
            currentWindEntity = CurrentWindEntity(
                deg = 1,
                gust = 1.0,
                speed = 1.0,
            ),
            currentSysEntity = CurrentSysEntity(
                country = "country",
                sunrise = 1,
                sunset = 1,
            ),
            currentCityWeatherId = 1
        )

        // Insert the Current City Weather into the Database...
        craftSiliconDao.insertCurrentWeather(currentCityWeatherEntity = currentCityWeatherEntity)

        // Then the Current City Weather is in the Database...
        val currentCityWeather = craftSiliconDao.getCurrentWeather()
        currentCityWeather.first()
            ?.let { assert(value = it == currentCityWeatherEntity) }

    }

    @Test
    fun testInsertAndGetForecastWeather() = runTest {
        // Given the Forecast City Weather...
        val forecastCityWeatherEntity =
            ForecastCityWeatherEntity(
                forecastCityWeatherId = 1,
                cnt = 1,
                cod = "cod",
                message = 1,
                list = listOf(),
                forecastCityEntity = emmanuelmuturia.home.source.local.entity.forecast.ForecastCityEntity(
                    forecastCoordEntity = emmanuelmuturia.home.source.local.entity.forecast.ForecastCoordEntity(
                        lat = 1.0,
                        lon = 1.0,
                    ),
                    country = "Kenya",
                    id = 1,
                    name = "Nairobi",
                    population = 1,
                    sunrise = 1,
                    sunset = 1,
                    timezone = 1,
                )
            )

        // Insert the Forecast City Weather into the Database...
        craftSiliconDao.insertForecastWeather(forecastCityWeatherEntity = forecastCityWeatherEntity)

        // Then the Forecast City Weather is in the Database...
        val forecastCityWeather = craftSiliconDao.getForecastWeather()
        assert(value = forecastCityWeather.first() == forecastCityWeatherEntity)

    }

}