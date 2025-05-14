package emmanuelmuturia.craftsilicon.home.source.local.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoordEntity(
    @SerialName("lat")
    val lat: Double,
    @SerialName("lon")
    val lon: Double
)