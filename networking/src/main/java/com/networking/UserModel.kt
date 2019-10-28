package com.networking

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val firstName: String,
    val lastName: String,
    val email: String,
    val points: Int = 0,
    val orders: List<Long>?
)
