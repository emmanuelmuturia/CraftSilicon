package emmanuelmuturia.craftsilicon.home.data.model

import emmanuelmuturia.craftsilicon.home.source.local.entity.MainEntity

data class Main(
    val feelsLike: Double,
    val grndLevel: Int,
    val humidity: Int,
    val pressure: Int,
    val seaLevel: Int,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
)

fun MainEntity.toMain(): Main {
    return Main(
        feelsLike = feelsLike,
        grndLevel = grndLevel,
        humidity = humidity,
        pressure = pressure,
        seaLevel = seaLevel,
        temp = temp,
        tempMax = tempMax,
        tempMin = tempMin
    )
}