package com.domainlayer.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

abstract class UseCase<Type, in Params> : CoroutineScope {
    private val job = SupervisorJob()

    abstract suspend fun run(params: Params): Flow<Type>

    override val coroutineContext: CoroutineContext
        get() = MainDispatcher + job

    fun cancel() {
        job.cancel()
    }
}
