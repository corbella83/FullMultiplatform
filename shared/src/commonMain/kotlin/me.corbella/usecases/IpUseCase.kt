package me.corbella.usecases

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import me.corbella.repositories.UserRepository

@Injectable(Scope.BY_USE)
internal class IpUseCase(private val userRepository: UserRepository) {

    suspend fun execute() =
        userRepository.getIpInfo()
            .ip

}