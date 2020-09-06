package me.corbella.repositories

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import me.corbella.datasources.ApiDataSource
import me.corbella.datasources.InfoDataSource
import me.corbella.repositories.mappers.IpInfoMapper

@Injectable(Scope.BY_USE)
internal class UserRepositoryImpl(
    private val infoDataSource: InfoDataSource,
    private val apiDataSource: ApiDataSource
) : UserRepository {

    private val ipInfoMapper = IpInfoMapper()

    override suspend fun getPlatformName() =
        infoDataSource.getName()

    override suspend fun getIpInfo() =
        apiDataSource.getIpInfo()
            .let { ipInfoMapper.map(it) }

}