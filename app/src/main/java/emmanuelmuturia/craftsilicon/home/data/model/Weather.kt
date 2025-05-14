package emmanuelmuturia.craftsilicon.home.data.model

import emmanuelmuturia.craftsilicon.home.source.local.entity.WeatherEntity

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

fun WeatherEntity.toWeather(): Weather {
    return Weather(
        description = description,
        icon = icon,
        id = id,
        main = main
    )
}