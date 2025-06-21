package com.fauzana0133.assesmentmobpro3.viewmodel

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class UserSession(private val context: Context) {
    private val Context.dataStore by preferencesDataStore("user_session")

    suspend fun saveUser(name: String, email: String, photoUrl: String) {
        context.dataStore.edit {
            it[stringPreferencesKey("name")] = name
            it[stringPreferencesKey("email")] = email
            it[stringPreferencesKey("photo")] = photoUrl
            it[booleanPreferencesKey("logged_in")] = true
        }
    }

    suspend fun isLoggedIn(): Boolean {
        val pref = context.dataStore.data.first()
        return pref[booleanPreferencesKey("logged_in")] ?: false
    }

    suspend fun clear() {
        context.dataStore.edit { it.clear() }
    }

    companion object PreferencesKeys {
        val name = stringPreferencesKey("name")
        val email = stringPreferencesKey("email")
        val photo = stringPreferencesKey("photo")
    }
}
