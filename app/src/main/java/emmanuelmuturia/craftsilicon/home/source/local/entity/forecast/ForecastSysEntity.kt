package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ForecastSysEntity")
data class ForecastSysEntity(
    @ColumnInfo(name = "pod")
    val pod: String
)