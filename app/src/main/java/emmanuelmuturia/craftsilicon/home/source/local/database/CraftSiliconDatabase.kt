package emmanuelmuturia.craftsilicon.home.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import emmanuelmuturia.craftsilicon.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.craftsilicon.home.source.local.entity.CityWeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.CloudsEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.CoordEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.MainEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.SysEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.WeatherEntity
import emmanuelmuturia.craftsilicon.home.source.local.entity.WindEntity
import emmanuelmuturia.craftsilicon.home.source.local.typeConverters.CraftSiliconTypeConverters

@Database(
    entities = [CityWeatherEntity::class, CloudsEntity::class, CoordEntity::class, MainEntity::class, SysEntity::class, WeatherEntity::class, WindEntity::class],
    version = 1
)
@TypeConverters(value = [CraftSiliconTypeConverters::class])
abstract class CraftSiliconDatabase : RoomDatabase() {
    abstract fun craftSiliconDao(): CraftSiliconDao
}