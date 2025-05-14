package emmanuelmuturia.craftsilicon.home.source.remote.source

interface HomeRemoteSource {
    suspend fun getCityWeather(city: String)
}