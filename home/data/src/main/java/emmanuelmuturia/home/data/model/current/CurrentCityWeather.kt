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
package emmanuelmuturia.home.data.model.current

data class CurrentCityWeather(
    val base: String,
    val currentClouds: CurrentClouds,
    val cod: Int,
    val currentCoord: CurrentCoord,
    val dt: Int,
    val id: Int,
    val currentMain: CurrentMain,
    val name: String,
    val currentSys: CurrentSys,
    val timezone: Int,
    val visibility: Int,
    val currentWeather: List<CurrentWeather>,
    val currentWind: CurrentWind,
    val lastUpdated: String,
)