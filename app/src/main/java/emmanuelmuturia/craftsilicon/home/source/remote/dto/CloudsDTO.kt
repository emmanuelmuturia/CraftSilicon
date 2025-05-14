package emmanuelmuturia.craftsilicon.home.source.remote.dto


import emmanuelmuturia.craftsilicon.home.source.local.entity.CloudsEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CloudsDTO(
    @SerialName("all")
    val all: Int
) {
    fun toCloudsEntity(): CloudsEntity {
        return CloudsEntity(
            all = all
        )
    }
}