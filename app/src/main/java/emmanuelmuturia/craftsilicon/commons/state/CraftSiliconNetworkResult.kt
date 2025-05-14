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
package emmanuelmuturia.craftsilicon.commons.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

/**
 * This is a Sealed Class that represents the app's States [Network Calls mostly]...
 */

sealed class CraftSiliconNetworkResult<out T> {
    data class Success<out T>(val data: T) : CraftSiliconNetworkResult<T>()

    data class Error(val error: String) : CraftSiliconNetworkResult<Nothing>()
}

/**
 * This is an extension function that converts a [Flow] into a [Flow] of [CraftSiliconNetworkResult]...
 */

fun <T> Flow<T>.asResult(): Flow<CraftSiliconNetworkResult<T>> {
    return this.map<T, CraftSiliconNetworkResult<T>> {
        CraftSiliconNetworkResult.Success(data = it)
    }.catch {
        emit(value = CraftSiliconNetworkResult.Error(error = it.message.toString()))
    }
}