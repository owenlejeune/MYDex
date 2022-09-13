package com.owenlejeune.mydex.preferences

import android.content.Context
import android.content.SharedPreferences
import com.kieronquinn.monetcompat.core.MonetCompat

class AppPreferences(context: Context) {

    enum class DarkMode {
        Automatic,
        Dark,
        Light
    }

    companion object {
        private val PREF_FILE = "tvtime_shared_preferences"

        private val CHROMA_MULTIPLIER = "chroma_multiplier"
        private val USE_SYSTEM_COLORS = "use_system_colors"
        private val SELECTED_COLOR = "selected_color"
        private val USE_WALLPAPER_COLORS = "use_wallpaper_colors"
        private val DARK_THEME = "dark_theme"
    }

    private val preferences: SharedPreferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)

    /******* Design Preferences ********/
    val useWallpaperColorsDefault: Boolean = true
    var useWallpaperColors: Boolean
        get() = preferences.getBoolean(USE_WALLPAPER_COLORS, useWallpaperColorsDefault)
        set(value) { preferences.put(USE_WALLPAPER_COLORS, value) }

    val darkThemeDefault: Int = DarkMode.Automatic.ordinal
    var darkTheme: Int
        get() = preferences.getInt(DARK_THEME, darkThemeDefault)
        set(value) { preferences.put(DARK_THEME, value) }

    val useSystemColorsDefault: Boolean = true
    var useSystemColors: Boolean
        get() = preferences.getBoolean(USE_SYSTEM_COLORS, useSystemColorsDefault)
        set(value) { preferences.put(USE_SYSTEM_COLORS, value) }

    val chromeMultiplyerDefault: Double = MonetCompat.chromaMultiplier.toFloat().toDouble()
    var chromaMultiplier: Double
        get() = preferences.getFloat(CHROMA_MULTIPLIER, chromeMultiplyerDefault.toFloat()).toDouble()
        set(value) { preferences.put(CHROMA_MULTIPLIER, value) }

    val selectedColorDefault: Int = Int.MAX_VALUE
    var selectedColor: Int
        get() = preferences.getInt(SELECTED_COLOR, selectedColorDefault)
        set(value) { preferences.put(SELECTED_COLOR, value) }

    /********* Helpers ********/
    private fun SharedPreferences.put(key: String, value: Any?) {
        edit().apply {
            when (value) {
                is Boolean -> putBoolean(key, value)
                is Int -> putInt(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                is Double -> putFloat(key, value.toFloat())
                is String -> putString(key, value)
                else -> throw UnsupportedTypeError()
            }
            apply()
        }
    }

    private fun SharedPreferences.putNullableString(key: String, value: String?) {
        edit().putString(key, value).apply()
    }

    class UnsupportedTypeError: Exception()

}