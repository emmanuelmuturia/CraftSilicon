package emmanuelmuturia.craftsilicon.home.source.remote.dto.forecast


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastWeatherItemDTO(
    @SerialName("clouds")
    val forecastCloudsDTO: ForecastCloudsDTO,
    @SerialName("dt")
    val dt: Int,
    @SerialName("dt_txt")
    val dtTxt: String,
    @SerialName("main")
    val forecastMainDTO: ForecastMainDTO,
    @SerialName("pop")
    val pop: Double,
    @SerialName("rain")
    val forecastRainDTO: ForecastRainDTO,
    @SerialName("sys")
    val forecastSysDTO: ForecastSysDTO,
    @SerialName("visibility")
    val visibility: Int,
    @SerialName("weather")
    val forecastWeatherDTO: List<ForecastWeatherDTO>,
    @SerialName("wind")
    val forecastWindDTO: ForecastWindDTO
)