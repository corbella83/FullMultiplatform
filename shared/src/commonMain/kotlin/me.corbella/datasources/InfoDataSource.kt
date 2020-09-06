package me.corbella.datasources

internal interface InfoDataSource {

    suspend fun getName(): String

}