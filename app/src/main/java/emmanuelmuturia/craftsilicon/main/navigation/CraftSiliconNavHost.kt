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
package emmanuelmuturia.craftsilicon.main.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import emmanuelmuturia.commons.ui.theme.CraftSiliconTheme
import emmanuelmuturia.home.ui.navigation.HomeScreen
import emmanuelmuturia.home.ui.navigation.homeScreen
import emmanuelmuturia.home.ui.viewmodel.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * This is The [NavHost] of the app...
 */

@Composable
fun CraftSiliconNavHost() {
    val navController = rememberNavController()

    val homeScreenViewModel: HomeScreenViewModel = koinViewModel()

    CraftSiliconTheme {
        Surface(
            modifier =
                Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxSize(),
        ) {
            NavHost(startDestination = HomeScreen, navController = navController) {
                homeScreen(
                    homeScreenViewModel = homeScreenViewModel,
                    onSearchCity = { cityName ->
                        homeScreenViewModel.searchNewCity(cityName = cityName)
                    },
                )
            }
        }
    }
}