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
package emmanuelmuturia.craftsilicon.home.data.model.current

import emmanuelmuturia.craftsilicon.home.source.local.entity.current.CurrentWindEntity

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double,
)

fun CurrentWindEntity.toWind(): Wind {
    return Wind(
        deg = deg,
        gust = gust,
        speed = speed,
    )
}