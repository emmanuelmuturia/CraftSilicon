/*
 * Copyright 2025 Craft Silicon
 *
 * Licenced under the Apache License, Version 2.0 (the "Licence");
 * you may not use this file except in compliance with the Licence.
 * You may obtain a copy of the Licence at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */
package emmanuelmuturia.home.ui.screen

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import emmanuelmuturia.home.data.model.current.CurrentCityWeather
import emmanuelmuturia.home.data.model.current.CurrentClouds
import emmanuelmuturia.home.data.model.current.CurrentCoord
import emmanuelmuturia.home.data.model.current.CurrentMain
import emmanuelmuturia.home.data.model.current.CurrentSys
import emmanuelmuturia.home.data.model.current.CurrentWeather
import emmanuelmuturia.home.data.model.current.CurrentWind
import emmanuelmuturia.home.data.model.forecast.ForecastCity
import emmanuelmuturia.home.data.model.forecast.ForecastCityWeather
import emmanuelmuturia.home.data.model.forecast.ForecastClouds
import emmanuelmuturia.home.data.model.forecast.ForecastCoord
import emmanuelmuturia.home.data.model.forecast.ForecastMain
import emmanuelmuturia.home.data.model.forecast.ForecastRain
import emmanuelmuturia.home.data.model.forecast.ForecastSys
import emmanuelmuturia.home.data.model.forecast.ForecastWeather
import emmanuelmuturia.home.data.model.forecast.ForecastWeatherItem
import emmanuelmuturia.home.data.model.forecast.ForecastWind
import emmanuelmuturia.home.ui.state.HomeScreenUIState
import org.junit.Rule
import org.junit.Test

/**
 * This is the Home Screen's UI Test...
 */

class HomeScreenUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val currentCityWeather =
        CurrentCityWeather(
            base = "",
            cod = 0,
            currentWeather =
                listOf(
                    CurrentWeather(
                        description = "",
                        icon = "",
                        id = 0,
                        main = "",
                    ),
                ),
            currentClouds =
                CurrentClouds(
                    all = 0,
                ),
            currentCoord =
                CurrentCoord(
                    lat = 0.0,
                    lon = 0.0,
                ),
            currentSys =
                CurrentSys(
                    country = "",
                    sunrise = 0,
                    sunset = 0,
                ),
            currentMain =
                CurrentMain(
                    feelsLike = 0.0,
                    humidity = 0,
                    pressure = 0,
                    temp = 0.0,
                    tempMax = 0.0,
                    grndLevel = 0,
                    seaLevel = 0,
                    tempMin = 0.0,
                ),
            currentWind =
                CurrentWind(
                    deg = 0,
                    speed = 0.0,
                    gust = 0.0,
                ),
            id = 0,
            name = "",
            visibility = 0,
            timezone = 0,
            dt = 0,
            lastUpdated = "",
        )

    private val foreCastCityWeather =
        ForecastCityWeather(
            forecastCity =
                ForecastCity(
                    forecastCoord =
                        ForecastCoord(
                            lat = 0.0,
                            lon = 0.0,
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
            list =
                listOf(
                    ForecastWeatherItem(
                        forecastWeather =
                            listOf(
                                ForecastWeather(
                                    description = "",
                                    icon = "",
                                    id = 0,
                                    main = "",
                                ),
                            ),
                        forecastMain =
                            ForecastMain(
                                feelsLike = 0.0,
                                grndLevel = 0,
                                humidity = 0,
                                pressure = 0,
                                seaLevel = 0,
                                temp = 0.0,
                                tempKf = 0.0,
                                tempMax = 0.0,
                                tempMin = 0.0,
                            ),
                        forecastRain =
                            ForecastRain(
                                h = 0.0,
                            ),
                        forecastWind =
                            ForecastWind(
                                deg = 0,
                                gust = 0.0,
                                speed = 0.0,
                            ),
                        forecastSys =
                            ForecastSys(
                                pod = "",
                            ),
                        forecastClouds =
                            ForecastClouds(
                                all = 1,
                            ),
                        dt = 1,
                        dtTxt = "",
                        pop = 0.0,
                        visibility = 1,
                        lastUpdated = "",
                    ),
                ),
            message = 0,
            lastUpdated = "",
        )

    @Test
    fun testHomeScreenContent() {
        with(receiver = composeTestRule) {
            setContent {
                HomeScreenContent(
                    homeScreenUIState =
                        HomeScreenUIState(
                            currentCityWeather = currentCityWeather,
                            foreCastCityWeather = foreCastCityWeather,
                            isLoading = false,
                            error = null,
                        ),
                    onSearchCity = {},
                )
            }

            onNodeWithContentDescription(label = "City Search Bar").assertIsDisplayed()
            onNodeWithContentDescription(label = "Current City Weather Card Label").assertIsDisplayed()
            onNodeWithContentDescription(label = "Forecast Weather Section Label").assertIsDisplayed()
            onAllNodesWithContentDescription(label = "Current City Weather Card").assertCountEquals(expectedSize = 1)
            onAllNodesWithContentDescription(label = "Forecast City Weather Card").assertCountEquals(expectedSize = 1)
        }
    }
}