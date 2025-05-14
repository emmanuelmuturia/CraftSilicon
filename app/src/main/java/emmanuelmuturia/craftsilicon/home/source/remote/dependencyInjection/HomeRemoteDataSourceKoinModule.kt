package emmanuelmuturia.craftsilicon.home.source.remote.dependencyInjection

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import emmanuelmuturia.craftsilicon.home.source.remote.api.OpenWeatherAPI
import emmanuelmuturia.craftsilicon.home.source.remote.source.HomeRemoteSource
import emmanuelmuturia.craftsilicon.home.source.remote.source.HomeRemoteSourceImplementation
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Retrofit

val homeRemoteDataSourceKoinModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory(contentType = "application/json".toMediaType()))
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build()
    }

    single<OpenWeatherAPI> {
        get<Retrofit>().create(OpenWeatherAPI::class.java)
    }

    single<HomeRemoteSource> {
        HomeRemoteSourceImplementation(
            openWeatherAPI = get(),
            dispatcher = get()
        )
    }

}