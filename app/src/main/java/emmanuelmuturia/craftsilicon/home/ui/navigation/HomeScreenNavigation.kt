package emmanuelmuturia.craftsilicon.home.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import emmanuelmuturia.craftsilicon.home.ui.screen.HomeScreen
import emmanuelmuturia.craftsilicon.home.ui.viewmodel.HomeScreenViewModel
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

fun NavGraphBuilder.homeScreen(
    homeScreenViewModel: HomeScreenViewModel
) {
    composable<HomeScreen> {
        HomeScreen(
            homeScreenViewModel = homeScreenViewModel
        )
    }
}