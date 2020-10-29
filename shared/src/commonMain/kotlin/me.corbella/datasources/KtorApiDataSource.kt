package me.corbella.datasources

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import me.corbella.datasources.model.IpInfoDTO

@Injectable(Scope.BY_USE)
internal class KtorApiDataSource(
    private val client: HttpClient,
    private val json: Json
) : ApiDataSource {

    override suspend fun getIpInfo() =
        client.get<String>("https://www.google.com/json")
            .let { json.decodeFromString(IpInfoDTO.serializer(), it) }


}