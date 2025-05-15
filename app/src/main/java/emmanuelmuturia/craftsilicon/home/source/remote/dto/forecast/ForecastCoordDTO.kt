package emmanuelmuturia.craftsilicon.home.source.remote.dto.forecast


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastCoordDTO(
    @SerialName("lat")
    val lat: Double,
    @SerialName("lon")
    val lon: Double
)