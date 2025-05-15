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
package emmanuelmuturia.craftsilicon.home.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import emmanuelmuturia.craftsilicon.home.ui.state.HomeScreenUIState
import emmanuelmuturia.craftsilicon.home.ui.viewmodel.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeScreenViewModel: HomeScreenViewModel,
) {
    val homeScreenUIState: HomeScreenUIState by
        homeScreenViewModel.homeScreenUIState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
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
        bottomBar = {
            // KebuBottomNavigationBar()
        },
    ) { paddingValues ->
        HomeScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
        )
    }
}

@Composable
private fun HomeScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Home Screen Content",
        )
    }
}