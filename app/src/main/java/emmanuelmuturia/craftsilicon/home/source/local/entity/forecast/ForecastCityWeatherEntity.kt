package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ForecastCityWeatherEntity")
data class ForecastCityWeatherEntity(
    @ColumnInfo(name = "city")
    val forecastCityEntity: ForecastCityEntity,
    @ColumnInfo(name = "cnt")
    val cnt: Int,
    @ColumnInfo(name = "cod")
    val cod: String,
    @ColumnInfo(name = "list")
    val list: List<ForecastWeatherItemEntity>,
    @ColumnInfo(name = "message")
    val message: Int
)