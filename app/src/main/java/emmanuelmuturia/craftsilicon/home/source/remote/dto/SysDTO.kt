package emmanuelmuturia.craftsilicon.home.source.remote.dto


import emmanuelmuturia.craftsilicon.home.source.local.entity.SysEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SysDTO(
    @SerialName("country")
    val country: String,
    @SerialName("sunrise")
    val sunrise: Int,
    @SerialName("sunset")
    val sunset: Int
) {
    fun toSysEntity(): SysEntity {
        return SysEntity(
            country = country,
            sunrise = sunrise,
            sunset = sunset
        )
    }
}