package me.corbella.usecases

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import me.corbella.repositories.UserRepository

@Injectable(Scope.BY_USE)
internal class LocationUseCase(private val userRepository: UserRepository) {

    suspend fun execute() =
        userRepository.getIpInfo()
            .location
            .let { "${it.latitude} ; ${it.longitude}" }

}