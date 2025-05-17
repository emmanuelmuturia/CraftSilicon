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

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import emmanuelmuturia.home.data.model.forecast.ForecastWeatherItem
import emmanuelmuturia.home.ui.state.HomeScreenUIState
import emmanuelmuturia.home.ui.viewmodel.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeScreenViewModel: HomeScreenViewModel,
    onSearchCity: (String) -> Unit,
) {
    val homeScreenUIState: HomeScreenUIState by
    homeScreenViewModel.homeScreenUIState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier =
                    Modifier.semantics {
                        contentDescription = "Home Screen Top App Bar"
                    },
                title = {
                    Text(
                        modifier =
                            Modifier.semantics {
                                contentDescription = "Home Screen Top App Bar Text"
                            },
                        text = "Home",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 21.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
    ) { paddingValues ->
        HomeScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            homeScreenUIState = homeScreenUIState,
            onSearchCity = onSearchCity,
        )
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    homeScreenUIState: HomeScreenUIState,
    onSearchCity: (String) -> Unit,
) {
    var citySearchQuery by rememberSaveable { mutableStateOf(value = "") }

    AnimatedVisibility(visible = homeScreenUIState.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onBackground,
                strokeWidth = 3.dp,
                trackColor = MaterialTheme.colorScheme.background
            )
        }
    }

    AnimatedVisibility(visible = homeScreenUIState.error != null) {
        val context = LocalContext.current
        Toast.makeText(context, "${homeScreenUIState.error}", Toast.LENGTH_LONG).show()
    }

    AnimatedVisibility(
        visible = !homeScreenUIState.isLoading,
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            item {
                OutlinedTextField(
                    modifier =
                        Modifier.semantics {
                            contentDescription = "City Search Bar"
                        },
                    value = citySearchQuery,
                    onValueChange = { citySearch ->
                        citySearchQuery = citySearch
                    },
                    trailingIcon = {
                        Icon(
                            modifier =
                                Modifier.clickable {
                                    onSearchCity(citySearchQuery)
                                },
                            imageVector = Icons.Rounded.Search,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Home Screen Search Icon",
                        )
                    },
                    label = {
                        Text(
                            modifier =
                                Modifier.semantics {
                                    contentDescription = "Home Screen Search Bar Label"
                                },
                            text = "Enter City Name...",
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 14.sp,
                        )
                    },
                    shape = RoundedCornerShape(size = 21.dp),
                    colors =
                        TextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.background,
                            unfocusedContainerColor = MaterialTheme.colorScheme.background,
                        ),
                )
            }

            item {
                Text(
                    text =
                        "Current Weather [${homeScreenUIState.currentCityWeather?.name}, " +
                            "${homeScreenUIState.currentCityWeather?.currentSys?.country}]",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    modifier =
                        Modifier
                            .padding(start = 14.dp, top = 10.dp, bottom = 4.dp)
                            .semantics {
                                contentDescription = "Current City Weather Card Label"
                            },
                )
                CurrentCityWeatherCard(
                    homeScreenUIState = homeScreenUIState,
                )
            }

            item {
                Text(
                    text = "The ${homeScreenUIState.foreCastCityWeather?.cnt}-Day Forecast",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    modifier =
                        Modifier
                            .padding(start = 14.dp, top = 10.dp, bottom = 4.dp)
                            .semantics {
                                contentDescription = "Forecast Weather Section Label"
                            },
                )
            }

            homeScreenUIState.foreCastCityWeather?.let {
                itemsIndexed(items = it.list) { index, forecastWeatherItem ->
                    Text(
                        text = "Day #${index + 1}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start,
                        modifier =
                            Modifier
                                .padding(start = 14.dp, top = 10.dp, bottom = 4.dp),
                    )
                    ForecastWeatherCard(
                        forecastWeatherItem = forecastWeatherItem,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun CurrentCityWeatherCard(homeScreenUIState: HomeScreenUIState) {
    val currentCityWeather = homeScreenUIState.currentCityWeather ?: return

    ElevatedCard(
        modifier =
            Modifier
                .padding(all = 14.dp)
                .fillMaxWidth()
                .semantics {
                    contentDescription = "Current City Weather Card"
                }
                .wrapContentHeight(),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            // Weather Condition + Icon
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Box(
                    modifier = Modifier.size(size = 77.dp),
                ) {
                    GlideImage(
                        model =
                            "https://openweathermap.org/img/wn/${
                                currentCityWeather.currentWeather.first().icon
                            }@2x.png",
                        contentDescription = "Weather Icon",
                        contentScale = ContentScale.Crop,
                    )
                }
                Column {
                    Text(
                        text = currentCityWeather.currentWeather.first().main,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = currentCityWeather.currentWeather.first().description.replaceFirstChar { it.uppercase() },
                        fontSize = 14.sp,
                        color = Color.Gray,
                    )
                }
            }

            CurrentWeatherDetailRow(
                title = "Last Updated",
                value = currentCityWeather.lastUpdated,
            )
            CurrentWeatherDetailRow(
                title = "Temperature",
                value = "${currentCityWeather.currentMain.temp} K",
            )
            CurrentWeatherDetailRow(
                title = "Temperature [Max]",
                value = "${currentCityWeather.currentMain.temp} K",
            )
            CurrentWeatherDetailRow(
                title = "Temperature [Min]",
                value = "${currentCityWeather.currentMain.temp} K",
            )
            CurrentWeatherDetailRow(
                title = "Feels Like",
                value = "${currentCityWeather.currentMain.feelsLike} K",
            )
            CurrentWeatherDetailRow(
                title = "Humidity",
                value = "${currentCityWeather.currentMain.humidity} %",
            )
            CurrentWeatherDetailRow(
                title = "Pressure",
                value = "${currentCityWeather.currentMain.pressure} hPa",
            )
            CurrentWeatherDetailRow(
                title = "Visibility",
                value = "${currentCityWeather.visibility / 1000} km",
            )
            CurrentWeatherDetailRow(
                title = "Sea Level",
                value = "${currentCityWeather.currentMain.seaLevel / 1000} km",
            )
            CurrentWeatherDetailRow(
                title = "Ground Level",
                value = "${currentCityWeather.currentMain.grndLevel / 1000} km",
            )
            CurrentWeatherDetailRow(
                title = "Cloudiness",
                value = "${currentCityWeather.currentClouds.all} %",
            )
            CurrentWeatherDetailRow(
                title = "Wind Speed",
                value = "${currentCityWeather.currentWind.speed} m/s",
            )
        }
    }
}

@Composable
private fun CurrentWeatherDetailRow(
    title: String,
    value: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ForecastWeatherCard(
    forecastWeatherItem: ForecastWeatherItem,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .wrapContentHeight()
                .semantics {
                    contentDescription = "Forecast City Weather Card"
                },
        shape = RoundedCornerShape(21.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Box(
                    modifier = Modifier.size(size = 77.dp),
                ) {

                    GlideImage(
                        model =
                            "https://openweathermap.org/img/wn/${
                                forecastWeatherItem.forecastWeather.first().icon
                            }@2x.png",
                        contentDescription = "Weather Icon",
                        contentScale = ContentScale.Crop,
                    )
                }
                Column {
                    Text(
                        text = forecastWeatherItem.forecastWeather.first().main,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = forecastWeatherItem.forecastWeather.first().description.replaceFirstChar { it.uppercase() },
                        fontSize = 14.sp,
                        color = Color.Gray,
                    )
                }
            }

            ForecastWeatherDetailRow(
                title = "Last Updated",
                value = forecastWeatherItem.lastUpdated,
            )
            ForecastWeatherDetailRow(
                title = "Temperature",
                value = "${forecastWeatherItem.forecastMain.temp} K",
            )
            ForecastWeatherDetailRow(
                title = "Temperature",
                value = "${forecastWeatherItem.forecastMain.temp} K",
            )
            ForecastWeatherDetailRow(
                title = "Visibility",
                value = "${forecastWeatherItem.visibility / 1000} Km",
            )
            ForecastWeatherDetailRow(
                title = "Feels Like",
                value = "${forecastWeatherItem.forecastMain.feelsLike} K",
            )
            ForecastWeatherDetailRow(
                title = "Ground Level",
                value = "${forecastWeatherItem.forecastMain.grndLevel} Km",
            )
            ForecastWeatherDetailRow(
                title = "Humidity",
                value = "${forecastWeatherItem.forecastMain.humidity} %",
            )
            ForecastWeatherDetailRow(
                title = "Pressure",
                value = "${forecastWeatherItem.forecastMain.pressure} hPa",
            )
            ForecastWeatherDetailRow(
                title = "Sea Level",
                value = "${forecastWeatherItem.forecastMain.seaLevel / 1000} Km",
            )
            ForecastWeatherDetailRow(
                title = "Temperature [Max]",
                value = "${forecastWeatherItem.forecastMain.tempMax} K",
            )
            ForecastWeatherDetailRow(
                title = "Temperature [Min]",
                value = "${forecastWeatherItem.forecastMain.tempMin} K",
            )
        }
    }
}

@Composable
private fun ForecastWeatherDetailRow(
    title: String,
    value: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}