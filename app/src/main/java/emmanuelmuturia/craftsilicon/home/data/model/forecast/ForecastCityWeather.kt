package emmanuelmuturia.craftsilicon.home.data.model.forecast

data class ForecastCityWeather(
    val forecastCity: ForecastCity,
    val cnt: Int,
    val cod: String,
    val list: List<ForecastWeatherItem>,
    val message: Int
)