package com.example.challengechapterfive

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {
    private var pref: SharedPreferences =
        context.getSharedPreferences(PREFS_ID, Context.MODE_PRIVATE)

    fun saveSharedPref(id: Int, username: String, email: String, password: String) {
        val editor = pref.edit()
        editor.putInt(KEY_ID, id)
        editor.putString(KEY_USERNAME, username)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_PASSWORD, password)
        editor.putBoolean(KEY_LOGIN, true)
        editor.apply()
    }

    fun checkLogin(): Boolean {
        return pref.getBoolean(KEY_LOGIN, false)
    }

    fun getEmail(): String {
        return pref.getString(KEY_EMAIL, null).toString()
    }

    fun getUsername(): String {
        return pref.getString(KEY_USERNAME, null).toString()
    }

    fun getPassword(): String {
        return pref.getString(KEY_PASSWORD, null).toString()
    }

    fun getUserId(): Int {
        return pref.getInt(KEY_ID, 0)
    }

    fun clearSharedPref() {
        val editor = pref.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        const val PREFS_ID = "auth_prefs"
        const val KEY_ID = "key_id"
        const val KEY_USERNAME = "key_username"
        const val KEY_EMAIL = "key_email"
        const val KEY_PASSWORD = "key_password"
        const val KEY_LOGIN = "key_login"
    }
}
