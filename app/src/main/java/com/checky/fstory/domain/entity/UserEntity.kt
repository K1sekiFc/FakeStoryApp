package com.checky.fstory.ui.domain.entity


data class UserEntity (
    val userId: String,
    val fullName: String,
    val username: String,
    val token: String,
    val email: String,
    val password :String,
    val phone: String

//    val userMode: UserMode
)

//sealed class UserMode(val userType: Int){
//    data object REGULAR_USER: UserMode(0)
//    data object ADMIN_USER: UserMode(1)
//    data object SUPER_USER: UserMode(2)
//    data object GUEST_USER: UserMode(3)
//}


