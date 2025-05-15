package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ForecastWind")
data class ForecastWindEntity(
    @ColumnInfo(name = "deg")
    val deg: Int,
    @ColumnInfo(name = "gust")
    val gust: Double,
    @ColumnInfo(name = "speed")
    val speed: Double
)