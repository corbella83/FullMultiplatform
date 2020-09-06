package me.corbella.datasources

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import me.corbella.PlatformData

@Injectable(Scope.BY_USE)
internal class PlatformInfoDataSource(
    private val data: PlatformData
) : InfoDataSource {

    override suspend fun getName() =
        data.getPlatformName()

}