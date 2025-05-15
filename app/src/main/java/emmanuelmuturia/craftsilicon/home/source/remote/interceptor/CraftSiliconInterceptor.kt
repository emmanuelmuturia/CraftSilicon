/*
 * Copyright 2025 Craft Silicon
 *
 * Licenced under the Apache License, Version 2.0 (the "Licence");
 * you may not use this file except in compliance with the Licence.
 * You may obtain a copy of the Licence at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */
package emmanuelmuturia.craftsilicon.home.source.remote.interceptor

import emmanuelmuturia.craftsilicon.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CraftSiliconInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl =
            originalUrl.newBuilder()
                .addQueryParameter(name = "APPID", value = BuildConfig.apiKey)
                .build()

        val newRequest =
            originalRequest.newBuilder()
                .url(url = newUrl)
                .build()

        return chain.proceed(request = newRequest)
    }
}