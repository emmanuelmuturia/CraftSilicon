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
package emmanuelmuturia.craftsilicon.home.source.remote.dto.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentCityWeatherDTO(
    @SerialName("base")
    val base: String,
    @SerialName("clouds")
    val currentCloudsDTO: CurrentCloudsDTO,
    @SerialName("cod")
    val cod: Int,
    @SerialName("coord")
    val currentCoordDTO: CurrentCoordDTO,
    @SerialName("dt")
    val dt: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("main")
    val currentMainDTO: CurrentMainDTO,
    @SerialName("name")
    val name: String,
    @SerialName("sys")
    val currentSysDTO: CurrentSysDTO,
    @SerialName("timezone")
    val timezone: Int,
    @SerialName("visibility")
    val visibility: Int,
    @SerialName("weather")
    val currentWeatherDTO: List<CurrentWeatherDTO>,
    @SerialName("wind")
    val currentWindDTO: CurrentWindDTO,
)