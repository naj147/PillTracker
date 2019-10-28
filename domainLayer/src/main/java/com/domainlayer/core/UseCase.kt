package com.domainlayer.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class UseCase<Type, in Params>(val dispatcher: CoroutineDispatcher = MainDispatcher) :
    CoroutineScope {
    //    val handler = CoroutineExceptionHandler { _, exception ->
//        Log.d(this::class.java.simpleName,"Caught $exception")
//    }
    private val job = SupervisorJob()

    abstract suspend fun run(params: Params): Type

    override val coroutineContext: CoroutineContext
        get() = dispatcher + job

    fun cancel() {
        job.cancel()
    }
}
