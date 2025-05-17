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
package emmanuelmuturia.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import emmanuelmuturia.commons.state.CraftSiliconNetworkResult
import emmanuelmuturia.commons.state.asResult
import emmanuelmuturia.home.data.repository.HomeRepository
import emmanuelmuturia.home.ui.state.HomeScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * This is the Home Screen's [ViewModel]...
 */

class HomeScreenViewModel(
    private val homeRepository: HomeRepository,
) : ViewModel() {
    val homeScreenUIState = MutableStateFlow(value = HomeScreenUIState())

    init {
        getCurrentCityWeather(cityName = homeScreenUIState.value.cityName)
        getForecastCityWeather(cityName = homeScreenUIState.value.cityName)
    }

    fun searchNewCity(cityName: String) {
        homeScreenUIState.value.cityName = cityName
        getWeatherByCityName(cityName = cityName)
    }

    fun getCurrentCityWeather(cityName: String) {
        homeScreenUIState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            homeRepository.getCurrentCityWeather(cityName = cityName).asResult().collect { result ->

                when (result) {
                    is CraftSiliconNetworkResult.Success -> {
                        homeScreenUIState.update {
                            it.copy(
                                isLoading = false,
                                currentCityWeather = result.data,
                            )
                        }
                    }

                    is CraftSiliconNetworkResult.Error -> {
                        homeScreenUIState.update {
                            it.copy(
                                isLoading = false,
                                error = result.error,
                            )
                        }
                    }
                }
            }
        }
    }

    fun getForecastCityWeather(cityName: String) {
        homeScreenUIState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            homeRepository.getForecastCityWeather(cityName = cityName).asResult().collect { result ->

                when (result) {
                    is CraftSiliconNetworkResult.Success -> {
                        homeScreenUIState.update {
                            it.copy(
                                isLoading = false,
                                foreCastCityWeather = result.data,
                            )
                        }
                    }

                    is CraftSiliconNetworkResult.Error -> {
                        homeScreenUIState.update {
                            it.copy(
                                isLoading = false,
                                error = result.error,
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getWeatherByCityName(cityName: String) {
        viewModelScope.launch {
            homeScreenUIState.update { it.copy(isLoading = true) }
            homeRepository.getWeatherByCityName(cityName = cityName)
            homeScreenUIState.update { it.copy(isLoading = false) }
        }
    }
}