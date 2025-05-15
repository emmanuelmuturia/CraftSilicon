package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ForecastCloudsEntity")
data class ForecastCloudsEntity(
    @ColumnInfo(name = "all")
    val all: Int
)