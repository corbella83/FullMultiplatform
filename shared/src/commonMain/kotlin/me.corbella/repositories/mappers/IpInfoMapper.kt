package me.corbella.repositories.mappers

import me.corbella.datasources.model.IpInfoDTO
import me.corbella.repositories.model.IpInfo
import me.corbella.repositories.model.Location


internal class IpInfoMapper {

    fun map(info: IpInfoDTO): IpInfo {
        return IpInfo(
            ip = info.query,
            country = info.country,
            region = info.regionName,
            city = info.city,
            location = Location(info.lat, info.lon)
        )
    }

}