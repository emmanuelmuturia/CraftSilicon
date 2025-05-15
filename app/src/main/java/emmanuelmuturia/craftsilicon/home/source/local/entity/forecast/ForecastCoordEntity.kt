package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ForecastCoordEntity")
data class ForecastCoordEntity(
    @ColumnInfo(name = "lat")
    val lat: Double,
    @ColumnInfo(name = "lon")
    val lon: Double
)