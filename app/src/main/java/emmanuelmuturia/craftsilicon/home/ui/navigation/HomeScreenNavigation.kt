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
package emmanuelmuturia.craftsilicon.home.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import emmanuelmuturia.craftsilicon.home.ui.screen.HomeScreen
import emmanuelmuturia.craftsilicon.home.ui.viewmodel.HomeScreenViewModel
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

fun NavGraphBuilder.homeScreen(
    homeScreenViewModel: HomeScreenViewModel,
    onSearchCity: (String) -> Unit
) {
    composable<HomeScreen> {
        HomeScreen(
            homeScreenViewModel = homeScreenViewModel,
            onSearchCity = onSearchCity
        )
    }
}