package me.corbella.repositories.model

data class IpInfo(
    val ip: String,
    val country: String,
    val region: String,
    val city: String,
    val location: Location
)