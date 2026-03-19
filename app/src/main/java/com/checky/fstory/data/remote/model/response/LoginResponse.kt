package com.checky.fstory.data.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse (
    val token: String
)