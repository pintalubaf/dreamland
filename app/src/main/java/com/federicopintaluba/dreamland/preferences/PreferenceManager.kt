package com.federicopintaluba.dreamland.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PreferenceKey.MASTER_KEY, 0)

    var characterCreated: Boolean
        get() = preferences.getBoolean(PreferenceKey.CHARACTER_CREATED, false)
        set(value) = preferences.edit().putBoolean(PreferenceKey.CHARACTER_CREATED, value).apply()
}