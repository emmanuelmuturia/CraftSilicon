package emmanuelmuturia.craftsilicon.home.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "CityWeatherEntity")
data class CityWeatherEntity(
    @ColumnInfo(name = "base")
    val base: String,
    @ColumnInfo(name = "clouds")
    val cloudsEntity: CloudsEntity,
    @ColumnInfo(name = "cod")
    val cod: Int,
    @ColumnInfo(name = "coord")
    val coordEntity: CoordEntity,
    @ColumnInfo(name = "dt")
    val dt: Int,
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "main")
    val mainEntity: MainEntity,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "sys")
    val sysEntity: SysEntity,
    @ColumnInfo(name = "timezone")
    val timezone: Int,
    @ColumnInfo(name = "visibility")
    val visibility: Int,
    @ColumnInfo(name = "weather")
    val weatherEntity: List<WeatherEntity>,
    @ColumnInfo(name = "wind")
    val windEntity: WindEntity
)