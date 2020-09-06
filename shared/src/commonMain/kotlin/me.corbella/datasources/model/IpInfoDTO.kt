package me.corbella.datasources.model

import kotlinx.serialization.Serializable

@Serializable
data class IpInfoDTO(
    val query: String,
    val status: String,
    val country: String,
    val countryCode: String,
    val regionName: String,
    val city: String,
    val zip: String,
    val lat: Float,
    val lon: Float,
    val timezone: String
)