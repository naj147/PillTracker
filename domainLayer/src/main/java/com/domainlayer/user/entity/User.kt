package com.domainlayer.user.entity

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val points: Int = 0,
    val orders: List<Long>?
)
