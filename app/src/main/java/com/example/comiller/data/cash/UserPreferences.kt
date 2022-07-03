package com.example.comiller.data.cash

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")

class UserPreferences constructor(context: Context) {

    private val appContext = context.applicationContext

    val accessToken: Flow<String?>
        get() = appContext.dataStore.data.map { preferences ->
            preferences[ACCESS_TOKEN]
        }

    val userEmail: Flow<String?>
        get() = appContext.dataStore.data.map { preferences ->
            preferences[USER_EMAIL]
        }

    val userName: Flow<String?>
        get() = appContext.dataStore.data.map { preferences ->
            preferences[USER_EMAIL]
        }

    val userPhone: Flow<String?>
        get() = appContext.dataStore.data.map { preferences ->
            preferences[USER_PHONE]
        }

    val agentID: Flow<String?>
        get() = appContext.dataStore.data.map { preferences ->
            preferences[AGENT_ID]
        }

    suspend fun saveAccessTokens(accessToken: String, userEmail: String, agentID: String, userName: String, userPhone: String) {
        appContext.dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = accessToken
            preferences[USER_EMAIL] = userEmail
            preferences[USER_NAME] = userName
            preferences[USER_PHONE] = userPhone
            preferences[AGENT_ID] = agentID
        }
    }

    suspend fun clear() {
        appContext.dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("key_access_token")
        private val USER_EMAIL = stringPreferencesKey("key_user_email")
        private val USER_NAME = stringPreferencesKey("key_user_name")
        private val USER_PHONE = stringPreferencesKey("key_user_phone")
        private val AGENT_ID = stringPreferencesKey("key_agent_id")
    }

}