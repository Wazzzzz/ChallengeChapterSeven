package com.example.challengechapterfive.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LogedDataStoreManager(private val context: Context) {

    fun getLogin(): Flow<Boolean> {
        return context.dataStore.data.map { pref ->
            pref[KEY_LOGIN] ?: false
        }
    }

    fun getEmail(): Flow<String> {
        return context.dataStore.data.map { pref ->
            pref[KEY_EMAIL] ?: "default"
        }
    }

    suspend fun saveDataLoged(email: String) {
        context.dataStore.edit { pref ->
            pref[KEY_EMAIL] = email
            pref[KEY_LOGIN] = true
        }
    }

    suspend fun clearData() {
        context.dataStore.edit { pref ->
            pref.clear()
        }
    }


    companion object {
        private const val DATA_STORE_NAME = "loged_preference"
        private val KEY_EMAIL = stringPreferencesKey("key_email")
        private val KEY_LOGIN = booleanPreferencesKey("key_login")
        private val Context.dataStore by preferencesDataStore(name = DATA_STORE_NAME)
    }

}
