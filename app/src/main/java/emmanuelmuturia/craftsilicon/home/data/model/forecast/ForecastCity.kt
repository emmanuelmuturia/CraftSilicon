package emmanuelmuturia.craftsilicon.home.data.model.forecast

import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCityEntity

data class ForecastCity(
    val forecastCoord: ForecastCoord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)

fun ForecastCityEntity.toForecastCity(): ForecastCity {
    return ForecastCity(
        forecastCoord = ForecastCoord(
            lat = forecastCoordEntity.lat,
            lon = forecastCoordEntity.lon,
        ),
        country = country,
        id = id,
        name = name,
        population = population,
        sunrise = sunrise,
        sunset = sunset,
        timezone = timezone,
    )
}