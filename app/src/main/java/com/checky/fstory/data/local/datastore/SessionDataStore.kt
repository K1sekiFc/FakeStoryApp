package com.checky.fstory.ui.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SessionDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    companion object {
        val TOKEN = stringPreferencesKey("token")
        val USER_ID = stringPreferencesKey("user_id")
    }

    suspend fun saveToken(token: String) {
        dataStore.edit { prefs ->
            prefs[TOKEN] = token
        }
    }

    suspend fun saveUserId(id: String) {
        dataStore.edit { prefs ->
            prefs[USER_ID] = id
        }
    }


    suspend fun clearSession() {
        dataStore.edit { it.clear() }
    }

    val getToken: Flow<String?> = dataStore.data.map { prefs ->
        prefs[TOKEN]
    }
    val getUserId: Flow<String?> = dataStore.data.map { prefs ->
        prefs[USER_ID]
    }

}