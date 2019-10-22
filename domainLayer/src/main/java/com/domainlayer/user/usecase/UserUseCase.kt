package com.domainlayer.user.usecase

import com.domainlayer.core.UseCase
import com.domainlayer.user.entity.User
import com.domainlayer.user.repository.UserRepository
import kotlinx.coroutines.withContext

class UserUseCase(private val userRepository: UserRepository) : UseCase<User, String>() {
    override suspend fun run(params: String): User =
        withContext(coroutineContext) { userRepository.getUser(token = params) }
}
