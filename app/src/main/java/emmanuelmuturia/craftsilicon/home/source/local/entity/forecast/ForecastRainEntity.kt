package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ForecastRainEntity")
data class ForecastRainEntity(
    @ColumnInfo(name = "3h")
    val h: Double
)