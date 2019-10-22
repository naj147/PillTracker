package com.domainlayer.user.repository

import com.domainlayer.user.entity.User

interface UserRepository {
    suspend fun getUser(token: String): User
}
