package com.mo2o.recipesearcher.domain.usecase

import com.mo2o.recipesearcher.domain.model.ApiError
import kotlinx.coroutines.*
import java.net.UnknownHostException

abstract class UseCase<T> {
    @Throws(Exception::class)
    abstract suspend fun execution(): Any

    private var result: Deferred<*>? = null

    fun execute(
        onSuccess: (T) -> Unit,
        apiError: () -> Unit
    ) {
        result = GlobalScope.async {
            try {
                execution()
            } catch (e: UnknownHostException) {
                ApiError()
            }
        }
        GlobalScope.launch(Dispatchers.Main) {
            result?.await()?.let {
                when (it) {
                    is ApiError -> apiError()
                    else -> onSuccess(it as T)
                }
            }
        }
    }

    fun cancel() {
        result?.cancel()
    }
}