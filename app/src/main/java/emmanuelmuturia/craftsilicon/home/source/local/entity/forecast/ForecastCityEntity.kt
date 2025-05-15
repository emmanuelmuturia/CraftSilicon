package emmanuelmuturia.craftsilicon.home.source.local.entity.forecast


import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ForecastCityEntity")
data class ForecastCityEntity(
    @ColumnInfo(name = "coord")
    val forecastCoordEntity: ForecastCoordEntity,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "population")
    val population: Int,
    @ColumnInfo(name = "sunrise")
    val sunrise: Int,
    @ColumnInfo(name = "sunset")
    val sunset: Int,
    @ColumnInfo(name = "timezone")
    val timezone: Int
)