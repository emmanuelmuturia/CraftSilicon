package emmanuelmuturia.craftsilicon.home.source.local.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CloudsEntity(
    @SerialName("all")
    val all: Int
)