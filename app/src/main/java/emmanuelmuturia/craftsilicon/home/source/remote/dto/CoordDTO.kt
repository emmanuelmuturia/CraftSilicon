package emmanuelmuturia.craftsilicon.home.source.remote.dto


import emmanuelmuturia.craftsilicon.home.source.local.entity.CoordEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoordDTO(
    @SerialName("lat")
    val lat: Double,
    @SerialName("lon")
    val lon: Double
) {
    fun toCoordEntity(): CoordEntity {
        return CoordEntity(
            lat = lat,
            lon = lon
        )
    }
}