package emmanuelmuturia.craftsilicon.home.source.remote.dto.forecast


import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastCloudsEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastMainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastRainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastSysEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWeatherItemEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWindEntity
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
) {
    fun toForecastWeatherItemEntity(): ForecastWeatherItemEntity {
        return ForecastWeatherItemEntity(
            forecastCloudsEntity = ForecastCloudsEntity(
                all = forecastCloudsDTO.all,
            ),
            dt = dt,
            dtTxt = dtTxt,
            forecastMainEntity = ForecastMainEntity(
                feelsLike = forecastMainDTO.feelsLike,
                grndLevel = forecastMainDTO.grndLevel,
                humidity = forecastMainDTO.humidity,
                pressure = forecastMainDTO.pressure,
                seaLevel = forecastMainDTO.seaLevel,
                temp = forecastMainDTO.temp,
                tempKf = forecastMainDTO.tempKf,
                tempMax = forecastMainDTO.tempMax,
                tempMin = forecastMainDTO.tempMin,
            ),
            pop = pop,
            forecastRainEntity = ForecastRainEntity(
                h = forecastRainDTO.h,
            ),
            forecastSysEntity = ForecastSysEntity(
                pod = forecastSysDTO.pod,
            ),
            visibility = visibility,
            forecastWeatherEntity = listOf(
                ForecastWeatherEntity(
                    description = forecastWeatherDTO.first().description,
                    icon = forecastWeatherDTO.first().icon,
                    id = forecastWeatherDTO.first().id,
                    main = forecastWeatherDTO.first().main,
                )
            ),
            forecastWindEntity = ForecastWindEntity(
                deg = forecastWindDTO.deg,
                gust = forecastWindDTO.gust,
                speed = forecastWindDTO.speed,
            )
        )
    }
}