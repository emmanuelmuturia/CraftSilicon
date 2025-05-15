package emmanuelmuturia.craftsilicon.home.source.remote.dto.forecast


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastRainDTO(
    @SerialName("3h")
    val h: Double
)