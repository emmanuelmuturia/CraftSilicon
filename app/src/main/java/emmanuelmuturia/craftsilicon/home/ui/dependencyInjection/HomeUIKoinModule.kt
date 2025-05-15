package emmanuelmuturia.craftsilicon.home.ui.dependencyInjection

import emmanuelmuturia.craftsilicon.home.ui.viewmodel.HomeScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeUIKoinModule = module {

    viewModel {
        HomeScreenViewModel(
            homeRepository = get()
        )
    }

}