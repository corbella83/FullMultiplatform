package me.corbella.datasources.engine

import cc.popkorn.annotations.InjectableProvider
import kotlinx.serialization.json.Json

@InjectableProvider
class JSonProvider {

    fun create() = Json { ignoreUnknownKeys = true }

}