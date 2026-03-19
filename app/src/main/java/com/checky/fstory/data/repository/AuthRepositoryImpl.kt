package com.checky.fstory.data.repository

import android.util.Log
import com.checky.fstory.data.remote.api.AuthApi
import com.checky.fstory.data.util.JwtUtils
import com.checky.fstory.data.local.datastore.SessionDataStore
import com.checky.fstory.data.remote.model.request.LoginRequest
import com.checky.fstory.data.remote.model.response.toDomain
//import com.abexa.myapplication1.ui.data.response.toDomain
import com.checky.fstory.domain.entity.UserEntity
import com.checky.fstory.domain.repository.AuthRepository
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val api: AuthApi, private val session: SessionDataStore) : AuthRepository {

    override suspend fun doLogin(user: String,password: String): UserEntity {

            // LOGIN
            val loginResponse = api.doLogin(
                LoginRequest(username = user, password = password)
            )

            val token = loginResponse.token

            // DECODIFICAR TOKEN
            val userId = JwtUtils.getUserIdFromJwt(token)
                ?: throw Exception("Invalid token")

            // GUARDAR EN DATASTORE
            session.saveToken(token)
            session.saveUserId(userId)

            // PEDIR USUARIO AL API
            val userResponse = api.getUserById(userId)
        return try {
            // MAPEAR A DOMAIN ENTITY
             userResponse.toDomain(token)

        }catch (e: Exception){
            Log.i("DoLOGIN ERROR", "$e")
            throw e
        }
    }
    override suspend fun getUserProfile(): UserEntity {
        val token = session.getToken.firstOrNull() ?: throw Exception("No token")
        val userId = session.getUserId.firstOrNull() ?: throw Exception("No userId")

        val userResponse = api.getUserById(userId)

        return userResponse.toDomain(token)
    }



//
//    override suspend fun doLogin(user: String, password: String): LoginEntity {
//        return try {
//
//            val response = api.doLogin(LoginRequest(username = user,password = password))
//            session.saveToken(response.token)
//            LoginEntity(token = response.token)
//        } catch (e: Exception) {
//            Log.i("DoLOGIN ERROR", "$e")
//            throw e
//        }
//    }
//
//    override suspend fun doLogin(user: String,password: String): List<UserEntity> {
//        val response = try {
//            api.doLogin()
//        }catch (e: Exception){
//            Log.i("DOLOGIN ERROR", "$e")
//            listOf()
//        }
//        return response.map {it.toDomain() }
//         return userResponse.toDomain()
}
