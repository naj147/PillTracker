package com.domainlayer.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

val MainDispatcher: CoroutineDispatcher
    get() = Dispatchers.Main
val IODispatcher: CoroutineDispatcher
    get() = Dispatchers.IO
val DefaultDispatcher: CoroutineDispatcher
    get() = Dispatchers.Default
