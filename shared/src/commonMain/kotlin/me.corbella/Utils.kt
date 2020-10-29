package me.corbella

import io.ktor.utils.io.*


suspend fun ByteReadChannel.readToString(): String {
    val buffer = ByteArray(4 * 1024)
    val stringBuilder = StringBuilder()
    var readLength: Int
    while (true) {
        readLength = readAvailable(buffer)
        if (readLength <= 0) break
        val value = buffer.decodeToString(0, readLength)
        stringBuilder.append(value)
    }
    return stringBuilder.toString()
}
