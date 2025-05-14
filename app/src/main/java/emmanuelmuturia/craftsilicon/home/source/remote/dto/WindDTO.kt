package emmanuelmuturia.craftsilicon.home.source.remote.dto


import emmanuelmuturia.craftsilicon.home.source.local.entity.WindEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WindDTO(
    @SerialName("deg")
    val deg: Int,
    @SerialName("gust")
    val gust: Double,
    @SerialName("speed")
    val speed: Double
) {
    fun toWindEntity(): WindEntity {
        return WindEntity(
            deg = deg,
            gust = gust,
            speed = speed
        )
    }
}