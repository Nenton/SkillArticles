package ru.skillbranch.skillarticles.data.local

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import ru.skillbranch.skillarticles.data.delegates.PrefDelegate
import java.lang.UnsupportedOperationException

/**
 * @author Susev Sergey
 */
class PrefManager(context: Context) {
   val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    var storedBoolean by PrefDelegate(false)
    var storedString by PrefDelegate("")
    var storedFloat by PrefDelegate(0f)
    var storedInt by PrefDelegate(0)
    var storedLong by PrefDelegate(0)

    fun clearAll() {
        preferences.edit().clear().apply()
    }
}