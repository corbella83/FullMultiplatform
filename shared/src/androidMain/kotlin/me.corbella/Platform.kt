package me.corbella

import cc.popkorn.annotations.Injectable
import io.ktor.client.*
import io.ktor.client.engine.android.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Injectable
internal actual class PlatformData {

    actual fun getPlatformName() = "android"

    actual fun getPlatformVersion() = "8.0"

}

internal actual val MainDispatcher: CoroutineDispatcher = Dispatchers.Main

internal actual val BackgroundDispatcher: CoroutineDispatcher = Dispatchers.Default

internal actual val httpClient = HttpClient(Android)
