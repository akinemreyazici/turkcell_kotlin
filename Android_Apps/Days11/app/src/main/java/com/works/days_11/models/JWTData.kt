package com.works.days_11.models

data class JWTData (
    val id: Long,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String // JWT bilgisi
)
