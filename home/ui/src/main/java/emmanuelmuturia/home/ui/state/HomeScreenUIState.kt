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
package emmanuelmuturia.home.ui.state

import emmanuelmuturia.home.data.model.current.CurrentCityWeather
import emmanuelmuturia.home.data.model.forecast.ForecastCityWeather

/**
 * This is the Home Screen UI State...
 */

data class HomeScreenUIState(
    val isLoading: Boolean = false,
    val currentCityWeather: CurrentCityWeather? = null,
    val foreCastCityWeather: ForecastCityWeather? = null,
    val error: String? = null,
    var cityName: String = "Nairobi",
)