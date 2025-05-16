package emmanuelmuturia.home.ui.viewmodel

import emmanuelmuturia.home.data.model.current.CurrentCityWeather
import emmanuelmuturia.home.data.model.current.CurrentClouds
import emmanuelmuturia.home.data.model.current.CurrentCoord
import emmanuelmuturia.home.data.model.current.CurrentMain
import emmanuelmuturia.home.data.model.current.CurrentSys
import emmanuelmuturia.home.data.model.current.CurrentWind
import emmanuelmuturia.home.data.model.forecast.ForecastCity
import emmanuelmuturia.home.data.model.forecast.ForecastCityWeather
import emmanuelmuturia.home.data.model.forecast.ForecastCoord
import emmanuelmuturia.home.data.repository.HomeRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


class HomeScreenViewModelTest {

    private val homeRepository: HomeRepository = mockk<HomeRepository>(relaxed = true)
    private lateinit var homeScreenViewModel: HomeScreenViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher = Dispatchers.Unconfined)
        homeScreenViewModel = HomeScreenViewModel(homeRepository = homeRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetCurrentCityWeather() = runTest {
        val currentCityWeather = CurrentCityWeather(
            base = "",
            cod = 0,
            currentWeather = listOf(),
            currentClouds = CurrentClouds(
                all = 0
            ),
            currentCoord = CurrentCoord(
                lat = 0.0,
                lon = 0.0
            ),
            currentSys = CurrentSys(
                country = "",
                sunrise = 0,
                sunset = 0,
            ),
            currentMain = CurrentMain(
                feelsLike = 0.0,
                humidity = 0,
                pressure = 0,
                temp = 0.0,
                tempMax = 0.0,
                grndLevel = 0,
                seaLevel = 0,
                tempMin = 0.0
            ),
            currentWind = CurrentWind(
                deg = 0,
                speed = 0.0,
                gust = 0.0
            ),
            id = 0,
            name = "",
            visibility = 0,
            timezone = 0,
            dt = 0,
            lastUpdated = 1L
        )

        // Given...
        coEvery { homeRepository.getCurrentCityWeather(cityName = "Nairobi") } returns flowOf(value = currentCityWeather)

        // When...
        homeScreenViewModel.getCurrentCityWeather(cityName = "Nairobi")
        coVerify { homeRepository.getCurrentCityWeather(cityName = "Nairobi") }

        // Then...
        val homeScreenUIState = homeScreenViewModel.homeScreenUIState.value
        assertEquals(currentCityWeather, homeScreenUIState.currentCityWeather)

    }

    @Test
    fun testGetForecastCityWeather() = runTest {
        val forecastCityWeather = ForecastCityWeather(
            forecastCity = ForecastCity(
                forecastCoord = ForecastCoord(
                    lat = 0.0,
                    lon = 0.0
                ),
                country = "",
                id = 0,
                name = "",
                population = 0,
                sunrise = 0,
                sunset = 0,
                timezone = 0,
            ),
            cnt = 1,
            cod = "",
            list = listOf(),
            message = 0,
        )

        // Given...
        coEvery { homeRepository.getForecastCityWeather(cityName = "Nairobi") } returns flowOf(value = forecastCityWeather)

        // When...
        homeScreenViewModel.getForecastCityWeather(cityName = "Nairobi")
        coVerify { homeRepository.getForecastCityWeather(cityName = "Nairobi") }

        // Then...
        val homeScreenUIState = homeScreenViewModel.homeScreenUIState.value
        assertEquals(forecastCityWeather, homeScreenUIState.foreCastCityWeather)

    }

}