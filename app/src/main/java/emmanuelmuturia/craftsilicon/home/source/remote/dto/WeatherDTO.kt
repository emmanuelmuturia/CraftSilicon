package emmanuelmuturia.craftsilicon.home.source.remote.dto


import emmanuelmuturia.craftsilicon.home.source.local.entity.WeatherEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDTO(
    @SerialName("description")
    val description: String,
    @SerialName("icon")
    val icon: String,
    @SerialName("id")
    val id: Int,
    @SerialName("main")
    val main: String
) {
    fun toWeatherEntity(): WeatherEntity {
        return WeatherEntity(
            description = description,
            icon = icon,
            id = id,
            main = main
        )
    }
}