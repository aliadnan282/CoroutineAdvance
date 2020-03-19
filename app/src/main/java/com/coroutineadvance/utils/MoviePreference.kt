package com.coroutineadvance.utils

import android.content.Context
import javax.inject.Inject

class MoviePreference @Inject constructor(context: Context) {
    private val prefs = context.getSharedPreferences("MOVIE_PREFS", Context.MODE_PRIVATE)
    fun getString(key: String) {
        prefs.getString(key, "")
    }

    fun getInt(key: String) {
        prefs.getInt(key, 1)
    }

    fun setString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun setInt(key: String, value: Int) {
        prefs.edit().putInt(key, value).apply()
    }
}