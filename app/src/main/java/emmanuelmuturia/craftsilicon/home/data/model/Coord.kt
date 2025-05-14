package emmanuelmuturia.craftsilicon.home.data.model

import emmanuelmuturia.craftsilicon.home.source.local.entity.CoordEntity

data class Coord(
    val lat: Double,
    val lon: Double
)

fun CoordEntity.toCoord(): Coord {
    return Coord(
        lat = lat,
        lon = lon
    )
}