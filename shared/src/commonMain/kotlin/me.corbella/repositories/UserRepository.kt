package me.corbella.repositories

import me.corbella.repositories.model.IpInfo


internal interface UserRepository {

    suspend fun getPlatformName(): String

    suspend fun getIpInfo(): IpInfo

}