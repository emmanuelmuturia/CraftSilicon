package emmanuelmuturia.craftsilicon.home.source.remote.api

import emmanuelmuturia.craftsilicon.home.source.remote.dto.CityWeatherDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
    ): Response<CityWeatherDTO>

}