package emmanuelmuturia.craftsilicon.main.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import emmanuelmuturia.craftsilicon.commons.ui.theme.CraftSiliconTheme
import emmanuelmuturia.craftsilicon.home.ui.navigation.HomeScreen
import emmanuelmuturia.craftsilicon.home.ui.navigation.homeScreen
import emmanuelmuturia.craftsilicon.home.ui.viewmodel.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CraftSiliconNavHost() {

    val navController = rememberNavController()

    val homeScreenViewModel: HomeScreenViewModel = koinViewModel()

    CraftSiliconTheme {
        Surface(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxSize()
        ) {
            NavHost(startDestination = HomeScreen, navController = navController) {
                homeScreen(
                    homeScreenViewModel = homeScreenViewModel
                )
            }
        }
    }

}