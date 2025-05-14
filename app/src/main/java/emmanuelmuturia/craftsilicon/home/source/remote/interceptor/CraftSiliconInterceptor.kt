package emmanuelmuturia.craftsilicon.home.source.remote.interceptor

import emmanuelmuturia.craftsilicon.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CraftSiliconInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter(name = "APPID", value = BuildConfig.apiKey)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(url = newUrl)
            .build()

        return chain.proceed(request = newRequest)
    }
}