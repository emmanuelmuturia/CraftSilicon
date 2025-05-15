package emmanuelmuturia.craftsilicon.home.source.remote.dto.forecast


import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCityEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCoordEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastCityDTO(
    @SerialName("coord")
    val forecastCoordDTO: ForecastCoordDTO,
    @SerialName("country")
    val country: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("population")
    val population: Int,
    @SerialName("sunrise")
    val sunrise: Int,
    @SerialName("sunset")
    val sunset: Int,
    @SerialName("timezone")
    val timezone: Int
) {
    fun toForecastCityEntity(): ForecastCityEntity {
        return ForecastCityEntity(
            forecastCoordEntity = ForecastCoordEntity(
                lat = forecastCoordDTO.lat,
                lon = forecastCoordDTO.lon,
            ),
            country = country,
            id = id,
            name = name,
            population = population,
            sunrise = sunrise,
            sunset = sunset,
            timezone = timezone,
            )
    }
}