package emmanuelmuturia.craftsilicon.home.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CloudsDTO(
    @SerialName("all")
    val all: Int
)