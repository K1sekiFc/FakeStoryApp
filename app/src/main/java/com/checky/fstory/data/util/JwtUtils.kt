package com.checky.fstory.ui.data.util

import android.util.Base64
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.io.encoding.ExperimentalEncodingApi

object JwtUtils {
    @OptIn(ExperimentalEncodingApi::class)
    fun getUserIdFromJwt(token: String): String? {
        return try {
            val parts = token.split(".")
            if (parts.size != 3) return null

            val payload = parts[1]
            val decodedBytes = Base64.decode(payload, Base64.URL_SAFE)
            val payloadJson = String(decodedBytes)

            val json = Json.Default.parseToJsonElement(payloadJson).jsonObject
            json["sub"]?.jsonPrimitive?.content
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    }
}