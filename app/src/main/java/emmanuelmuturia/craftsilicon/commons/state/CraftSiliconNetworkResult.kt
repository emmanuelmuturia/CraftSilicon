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