package me.corbella.datasources.engine

import cc.popkorn.annotations.InjectableProvider
import me.corbella.httpClient

@InjectableProvider
class HttpClientProvider {

    fun create() = httpClient

}