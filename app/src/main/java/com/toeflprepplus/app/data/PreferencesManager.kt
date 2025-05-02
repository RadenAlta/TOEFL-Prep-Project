package com.toeflprepplus.app.data

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.preference.PreferenceManager

class PreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    // Get Dark Mode preference
    fun getDarkModePreference(): Boolean {
        return sharedPreferences.getBoolean("pref_theme", false)
    }

    // Set Dark Mode preference
    fun setDarkModePreference(isEnabled: Boolean) {
        sharedPreferences.edit().putBoolean("pref_theme", isEnabled).apply()
    }

    // Get Sound preference
    fun getSoundPreference(): Boolean {
        return sharedPreferences.getBoolean("pref_sound", true)
    }

    // Set Sound preference
    fun setSoundPreference(isEnabled: Boolean) {
        sharedPreferences.edit().putBoolean("pref_sound", isEnabled).apply()
    }

    // Get Language preference
    fun getLanguagePreference(): String {
        return sharedPreferences.getString("pref_language", "en") ?: "en"
    }

    // Set Language preference
    fun setLanguagePreference(language: String) {
        sharedPreferences.edit().putString("pref_language", language).apply()
    }
}

@Composable
fun PreferencesPreview() {
    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)

    // Example: Getting and Setting Preferences
    val isDarkMode = preferencesManager.getDarkModePreference()
    val isSoundEnabled = preferencesManager.getSoundPreference()
    val currentLanguage = preferencesManager.getLanguagePreference()

    // You can show these preferences in your Composables or use them for other logic
    println("Dark Mode: $isDarkMode")
    println("Sound Enabled: $isSoundEnabled")
    println("Language: $currentLanguage")
}

@Preview
@Composable
fun PreferencesPreviewScreen() {
    PreferencesPreview()
}
