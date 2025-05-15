package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ForecastMainEntity")
data class ForecastMainEntity(
    @ColumnInfo(name = "feels_like")
    val feelsLike: Double,
    @ColumnInfo(name = "grnd_level")
    val grndLevel: Int,
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    @ColumnInfo(name = "pressure")
    val pressure: Int,
    @ColumnInfo(name = "sea_level")
    val seaLevel: Int,
    @ColumnInfo(name = "temp")
    val temp: Double,
    @ColumnInfo(name = "temp_kf")
    val tempKf: Double,
    @ColumnInfo(name = "temp_max")
    val tempMax: Double,
    @ColumnInfo(name = "temp_min")
    val tempMin: Double
)