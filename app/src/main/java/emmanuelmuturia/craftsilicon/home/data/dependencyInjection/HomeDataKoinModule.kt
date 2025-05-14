package emmanuelmuturia.craftsilicon.home.data.dependencyInjection

import emmanuelmuturia.craftsilicon.home.data.repository.HomeRepository
import emmanuelmuturia.craftsilicon.home.data.repository.HomeRepositoryImplementation
import org.koin.dsl.module

val homeDataKoinModule = module {

    single<HomeRepository> {
        HomeRepositoryImplementation(
            homeLocalSource = get(),
            dispatcher = get()
        )
    }

}