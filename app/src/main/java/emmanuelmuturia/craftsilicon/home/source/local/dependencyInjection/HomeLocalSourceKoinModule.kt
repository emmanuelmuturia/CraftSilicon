package emmanuelmuturia.craftsilicon.home.source.local.dependencyInjection

import androidx.room.Room
import emmanuelmuturia.craftsilicon.home.source.local.dao.CraftSiliconDao
import emmanuelmuturia.craftsilicon.home.source.local.database.CraftSiliconDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val homeLocalSourceKoinModule = module {

    single<CraftSiliconDatabase> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = CraftSiliconDatabase::class.java,
            name = "CraftSiliconDatabase"
        ).build()
    }

    single<CraftSiliconDao> {
        get<CraftSiliconDatabase>().craftSiliconDao()
    }

}