package me.corbella.repositories.model

enum class EParam(val value: String) {
    IP("ip"),
    COUNTRY("country"),
    LOCATION("location"),
    PLATFORM("platform");


    companion object {

        fun fromString(string: String): EParam {
            return values().find { it.value == string } ?: throw RuntimeException("Param not available")
        }

    }

}