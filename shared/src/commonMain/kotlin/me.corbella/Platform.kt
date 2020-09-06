package me.corbella

import io.ktor.client.*
import kotlinx.coroutines.CoroutineDispatcher


internal expect class PlatformData() {

    fun getPlatformName(): String

    fun getPlatformVersion(): String

}

internal expect val MainDispatcher: CoroutineDispatcher

internal expect val BackgroundDispatcher: CoroutineDispatcher

internal expect val httpClient: HttpClient
