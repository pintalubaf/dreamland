package com.federicopintaluba.dreamland.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PreferenceKey.MASTER_KEY, 0)

    var characterCreated: Boolean
        get() = preferences.getBoolean(PreferenceKey.CHARACTER_CREATED, false)
        set(value) = preferences.edit().putBoolean(PreferenceKey.CHARACTER_CREATED, value).apply()

    var characterName: String?
        get() = preferences.getString(PreferenceKey.CHARACTER_NAME, "")
        set(value) = preferences.edit().putString(PreferenceKey.CHARACTER_NAME, value).apply()

    var characterClass: String?
        get() = preferences.getString(PreferenceKey.CHARACTER_CLASS, "")
        set(value) = preferences.edit().putString(PreferenceKey.CHARACTER_CLASS, value).apply()

    var characterLevel: Int
        get() = preferences.getInt(PreferenceKey.CHARACTER_LEVEL, 0)
        set(value) = preferences.edit().putInt(PreferenceKey.CHARACTER_LEVEL, value).apply()

    var characterMaxHp: Int
        get() = preferences.getInt(PreferenceKey.CHARACTER_MAX_HP, 0)
        set(value) = preferences.edit().putInt(PreferenceKey.CHARACTER_MAX_HP, value).apply()

    var characterCurrentHp: Int
        get() = preferences.getInt(PreferenceKey.CHARACTER_CURRENT_HP, 0)
        set(value) = preferences.edit().putInt(PreferenceKey.CHARACTER_CURRENT_HP, value).apply()

    var characterAtk: Int
        get() = preferences.getInt(PreferenceKey.CHARACTER_ATK, 0)
        set(value) = preferences.edit().putInt(PreferenceKey.CHARACTER_ATK, value).apply()

    var characterDef: Int
        get() = preferences.getInt(PreferenceKey.CHARACTER_DEF, 0)
        set(value) = preferences.edit().putInt(PreferenceKey.CHARACTER_DEF, value).apply()

    var characterGold: Int
        get() = preferences.getInt(PreferenceKey.CHARACTER_GOLD, 0)
        set(value) = preferences.edit().putInt(PreferenceKey.CHARACTER_GOLD, value).apply()

    var characterXp: Int
        get() = preferences.getInt(PreferenceKey.CHARACTER_XP, 0)
        set(value) = preferences.edit().putInt(PreferenceKey.CHARACTER_XP, value).apply()
}