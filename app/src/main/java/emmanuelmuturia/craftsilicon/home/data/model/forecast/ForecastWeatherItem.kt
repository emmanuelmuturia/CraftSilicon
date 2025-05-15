package emmanuelmuturia.craftsilicon.home.data.model.forecast

import emmanuelmuturia.craftsilicon.home.source.local.entity.forecast.ForecastWeatherItemEntity

data class ForecastWeatherItem(
    val forecastClouds: ForecastClouds,
    val dt: Int,
    val dtTxt: String,
    val forecastMain: ForecastMain,
    val pop: Double,
    val forecastRain: ForecastRain,
    val forecastSys: ForecastSys,
    val visibility: Int,
    val forecastWeather: List<ForecastWeather>,
    val forecastWind: ForecastWind
)

fun ForecastWeatherItemEntity.toForecastWeatherItem(): ForecastWeatherItem {
    return ForecastWeatherItem(
        forecastClouds = ForecastClouds(
            all = forecastCloudsEntity.all
        ),
        dt = dt,
        dtTxt = dtTxt,
        forecastMain = ForecastMain(
            feelsLike = forecastMainEntity.feelsLike,
            grndLevel = forecastMainEntity.grndLevel,
            humidity = forecastMainEntity.humidity,
            pressure = forecastMainEntity.pressure,
            seaLevel = forecastMainEntity.seaLevel,
            temp = forecastMainEntity.temp,
            tempKf = forecastMainEntity.tempKf,
            tempMax = forecastMainEntity.tempMax,
            tempMin = forecastMainEntity.tempMin
        ),
        pop = pop,
        forecastRain = ForecastRain(
            h = forecastRainEntity.h
        ),
        forecastSys = ForecastSys(
            pod = forecastSysEntity.pod
        ),
        visibility = visibility,
        forecastWeather = forecastWeatherEntity.map { forecastWeatherEntity ->
            ForecastWeather(
                description = forecastWeatherEntity.description,
                icon = forecastWeatherEntity.icon,
                id = forecastWeatherEntity.id,
                main = forecastWeatherEntity.main
            )
        },
        forecastWind = ForecastWind(
            deg = forecastWindEntity.deg,
            gust = forecastWindEntity.gust,
            speed = forecastWindEntity.speed
        ),

    )
}