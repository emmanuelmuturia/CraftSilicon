package emmanuelmuturia.craftsilicon.home.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityWeatherDTO(
    @SerialName("base")
    val base: String,
    @SerialName("clouds")
    val cloudsDTO: CloudsDTO,
    @SerialName("cod")
    val cod: Int,
    @SerialName("coord")
    val coordDTO: CoordDTO,
    @SerialName("dt")
    val dt: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("main")
    val mainDTO: MainDTO,
    @SerialName("name")
    val name: String,
    @SerialName("sys")
    val sysDTO: SysDTO,
    @SerialName("timezone")
    val timezone: Int,
    @SerialName("visibility")
    val visibility: Int,
    @SerialName("weather")
    val weatherDTO: List<WeatherDTO>,
    @SerialName("wind")
    val windDTO: WindDTO
)