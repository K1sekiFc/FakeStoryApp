package com.checky.fstory.ui.data.remote.model.response

import com.checky.fstory.ui.domain.entity.UserEntity
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: String,
    val name: Name,
    val username: String,
    val email:String,
    val password :String,
    val phone : String

)

@Serializable
data class Name(
    val firstname: String,
    val lastname: String
)

@Serializable
data class Address(
    val city: String,
    val street: String,
    val number: Int,
    val zipcode: String,
    val geolocation: GeoLocation,
)

@Serializable
data class GeoLocation(
    val lat: String,
    val long: String
)

fun UserResponse.toDomain(token: String): UserEntity {
    return UserEntity(
        userId = id,
        fullName = "${name.firstname} ${name.lastname}",
        username = username,
        token = token,
        email = email,
        password = password,
        phone = phone
    )

//fun UserResponse.toDomain(): UserEntity {
//
//    val userMode = when (userMode) {
//        REGULAR_USER.userType-> REGULAR_USER
//        ADMIN_USER.userType-> ADMIN_USER
//        SUPER_USER.userType-> SUPER_USER
//        GUEST_USER.userType-> GUEST_USER
//        else -> {
//            REGULAR_USER
//        }
//    }

//    return UserEntity(
//        userId = userId,
//        name = name,
//        nickname = nickname,
//        userMode = userMode
//    )
}
