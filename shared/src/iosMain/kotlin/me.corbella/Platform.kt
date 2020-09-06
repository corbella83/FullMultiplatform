package me.corbella

import cc.popkorn.annotations.Injectable
import io.ktor.client.*
import io.ktor.client.engine.ios.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext


@Injectable
internal actual class PlatformData {

    actual fun getPlatformName() = "ios"

    actual fun getPlatformVersion() = "11.0"

}


internal actual val MainDispatcher: CoroutineDispatcher = NsQueueDispatcher(dispatch_get_main_queue())

internal actual val BackgroundDispatcher: CoroutineDispatcher = Main

internal actual val httpClient = HttpClient(Ios)

internal class NsQueueDispatcher(private val dispatchQueue: dispatch_queue_t) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}