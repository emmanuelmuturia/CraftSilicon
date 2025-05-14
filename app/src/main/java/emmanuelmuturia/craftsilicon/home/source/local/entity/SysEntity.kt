package emmanuelmuturia.craftsilicon.home.source.local.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SysEntity(
    @SerialName("country")
    val country: String,
    @SerialName("sunrise")
    val sunrise: Int,
    @SerialName("sunset")
    val sunset: Int
)