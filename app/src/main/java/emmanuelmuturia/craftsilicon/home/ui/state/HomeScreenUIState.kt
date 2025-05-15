package emmanuelmuturia.craftsilicon.home.ui.state

import emmanuelmuturia.craftsilicon.home.data.model.CityWeather

data class HomeScreenUIState(
    val isLoading: Boolean = false,
    val cityWeather: CityWeather? = null,
    val error: String? = null,
    val cityName: String = "Nairobi"
)