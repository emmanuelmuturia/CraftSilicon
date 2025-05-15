package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ForecastWeatherItemEntity")
data class ForecastWeatherItemEntity(
    @ColumnInfo(name = "clouds")
    val forecastCloudsEntity: ForecastCloudsEntity,
    @ColumnInfo(name = "dt")
    val dt: Int,
    @ColumnInfo(name = "dt_txt")
    val dtTxt: String,
    @ColumnInfo(name = "main")
    val forecastMainEntity: ForecastMainEntity,
    @ColumnInfo(name = "pop")
    val pop: Double,
    @ColumnInfo(name = "rain")
    val forecastRainEntity: ForecastRainEntity,
    @ColumnInfo(name = "sys")
    val forecastSysEntity: ForecastSysEntity,
    @ColumnInfo(name = "visibility")
    val visibility: Int,
    @ColumnInfo(name = "weather")
    val forecastWeatherEntity: List<ForecastWeatherEntity>,
    @ColumnInfo(name = "wind")
    val forecastWindEntity: ForecastWindEntity
)