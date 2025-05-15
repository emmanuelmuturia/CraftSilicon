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
package emmanuelmuturia.craftsilicon.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import emmanuelmuturia.craftsilicon.commons.state.CraftSiliconNetworkResult
import emmanuelmuturia.craftsilicon.commons.state.asResult
import emmanuelmuturia.craftsilicon.home.data.repository.HomeRepository
import emmanuelmuturia.craftsilicon.home.ui.state.HomeScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val homeRepository: HomeRepository,
) : ViewModel() {
    val homeScreenUIState = MutableStateFlow(value = HomeScreenUIState())

    init {
        getCityWeather(city = homeScreenUIState.value.cityName)
    }

    private fun getCityWeather(city: String) {
        homeScreenUIState.value = HomeScreenUIState(isLoading = true)
        viewModelScope.launch {
            homeRepository.getCityWeather(city = city).asResult().collect { result ->

                when (result) {
                    is CraftSiliconNetworkResult.Success -> {
                        homeScreenUIState.update {
                            it.copy(
                                isLoading = false,
                                cityWeather = result.data,
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
}