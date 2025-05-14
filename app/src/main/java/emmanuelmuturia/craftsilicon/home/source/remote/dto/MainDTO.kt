package emmanuelmuturia.craftsilicon.home.source.remote.dto


import emmanuelmuturia.craftsilicon.home.source.local.entity.MainEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainDTO(
    @SerialName("feels_like")
    val feelsLike: Double,
    @SerialName("grnd_level")
    val grndLevel: Int,
    @SerialName("humidity")
    val humidity: Int,
    @SerialName("pressure")
    val pressure: Int,
    @SerialName("sea_level")
    val seaLevel: Int,
    @SerialName("temp")
    val temp: Double,
    @SerialName("temp_max")
    val tempMax: Double,
    @SerialName("temp_min")
    val tempMin: Double
) {
    fun toMainEntity(): MainEntity {
        return MainEntity(
            feelsLike = feelsLike,
            grndLevel = grndLevel,
            humidity = humidity,
            pressure = pressure,
            seaLevel = seaLevel,
            temp = temp,
            tempMax = tempMax,
            tempMin = tempMin
        )
    }
}