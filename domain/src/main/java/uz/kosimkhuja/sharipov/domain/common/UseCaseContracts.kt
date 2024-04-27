package uz.kosimkhuja.sharipov.domain.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

@Suppress("InjectDispatcher")
abstract class InteractorUseCase<in Input, Output> {
    protected abstract val state: MutableStateFlow<Result<Output>>

    protected fun updateState(newList: Output) {
        state.value = Result.success(newList)
    }

    protected fun updateState(throwable: Throwable) {
        state.value = Result.failure(throwable)
    }

    /**
     * Executes the flow on Dispatchers.IO and wraps exceptions inside it into Result
     */
    suspend operator fun invoke(param: Input): StateFlow<Result<Output>> {
        if (isStateEmpty()) {
            try {
                updateState(execute(param))
            } catch (e: Exception) {
                updateState(e)
            }
        }
        return state
    }

    protected abstract suspend fun execute(param: Input): Output

    protected abstract fun isStateEmpty(): Boolean
}

@Suppress("InjectDispatcher")
interface LocalFlowUseCase<in Input, Output> {
    /**
     * Executes the flow on Dispatchers.IO
     * Doesn't handle exception, since it's not likely to happen while collecting from db
     */
    operator fun invoke(param: Input): Flow<Output> =
        execute(param).flowOn(Dispatchers.IO)

    fun execute(param: Input): Flow<Output>
}

@Suppress("InjectDispatcher")
interface FlowUseCase<in Input, Output> {
    /**
     * Executes the flow on Dispatchers.IO and wraps exceptions inside it into Result
     */
    operator fun invoke(param: Input): Flow<Result<Output>> =
        execute(param)
            .catch { e -> emit(Result.failure(e)) }
            .flowOn(Dispatchers.IO)

    fun execute(param: Input): Flow<Result<Output>>
}

@Suppress("InjectDispatcher")
interface SuspendedUseCase<in Input, Output> {
    suspend operator fun invoke(param: Input): Output =
        withContext(Dispatchers.IO) { execute(param) }

    suspend fun execute(param: Input): Output
}
