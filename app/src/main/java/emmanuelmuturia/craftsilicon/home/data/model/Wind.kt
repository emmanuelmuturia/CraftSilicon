package emmanuelmuturia.craftsilicon.home.data.model

import emmanuelmuturia.craftsilicon.home.source.local.entity.WindEntity

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)

fun WindEntity.toWind(): Wind {
    return Wind(
        deg = deg,
        gust = gust,
        speed = speed
    )
}