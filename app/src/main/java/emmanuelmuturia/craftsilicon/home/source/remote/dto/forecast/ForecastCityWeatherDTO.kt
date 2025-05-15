package emmanuelmuturia.craftsilicon.home.source.remote.dto.forecast


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastCityWeatherDTO(
    @SerialName("city")
    val forecastCityDTO: ForecastCityDTO,
    @SerialName("cnt")
    val cnt: Int,
    @SerialName("cod")
    val cod: String,
    @SerialName("list")
    val list: List<ForecastWeatherItemDTO>,
    @SerialName("message")
    val message: Int
)