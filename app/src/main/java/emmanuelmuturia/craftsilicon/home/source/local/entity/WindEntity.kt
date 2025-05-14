package emmanuelmuturia.craftsilicon.home.source.local.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WindEntity(
    @SerialName("deg")
    val deg: Int,
    @SerialName("gust")
    val gust: Double,
    @SerialName("speed")
    val speed: Double
)