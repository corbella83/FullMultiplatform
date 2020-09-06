package me.corbella.datasources

import me.corbella.datasources.model.IpInfoDTO

internal interface ApiDataSource {

    suspend fun getIpInfo(): IpInfoDTO

}