package com.domainlayer.user

import com.domainlayer.user.entity.User
import com.domainlayer.user.repository.UserRepository
import com.domainlayer.user.usecase.UserUseCase
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@ExperimentalCoroutinesApi
class GetUserUseCaseTest {
    private val userRepository = spyk<UserRepository>()
    private val userUserCase = UserUseCase(userRepository)
    private val userId = "12345"
    private val user = mockk<User>()

    @Test
    fun `should get correct user provided by backend`() {
        runBlockingTest {
            coEvery {
                userRepository.getUser(any())
            } returns user
        }
    }

    @Test(expected = Exception::class)
    fun `should throw exception`() {
        val exception = Exception("exception")
        runBlockingTest {
            coEvery {
                userRepository.getUser(any())
            } throws exception
            userUserCase.run(userId)
        }
    }
}
