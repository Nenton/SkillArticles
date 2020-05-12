package ru.skillbranch.skillarticles.data.delegates

import ru.skillbranch.skillarticles.data.local.PrefManager
import java.lang.UnsupportedOperationException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author Susev Sergey
 *
 * Необходимо реализовать делегат для получения значений примитивов (Boolean, String, Float, Int, Long) из SharedPreferences
 * Реализуй делегат PrefDelegate<T>(private val defaultValue: T) : ReadWriteProperty<PrefManager, T?>
 * (ru.skillbranch.skillarticles.data.delegates.PrefDelegate) возвращающий значений примитивов (Boolean, String, Float, Int, Long)
 *
 * Пример: var storedBoolean by PrefDelegate(false)
 * var storedString by PrefDelegate("")
 * var storedFloat by PrefDelegate(0f)
 * var storedInt by PrefDelegate(0)
 * var storedLong by PrefDelegate(0)
 *
 * Реализуй в классе PrefManager(context:Context) (ru.skillbranch.skillarticles.data.local.PrefManager)
 * свойство val preferences : SharedPreferences проинициализированое экземпляром SharedPreferences приложения.
 * И метод fun clearAll() - очищающий все сохраненные значения SharedPreferences приложения.
 * Использовать PrefManager из androidx (import androidx.preference.PreferenceManager)
 */
class PrefDelegate<T>(private val defaultValue: T) : ReadWriteProperty<PrefManager, T?> {

    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    override fun getValue(thisRef: PrefManager, property: KProperty<*>): T? {
        return when (defaultValue) {
            is Boolean -> thisRef.preferences.getBoolean(property.name, defaultValue)
            is String -> thisRef.preferences.getString(property.name, defaultValue)
            is Float -> thisRef.preferences.getFloat(property.name, defaultValue)
            is Int -> thisRef.preferences.getInt(property.name, defaultValue)
            is Long -> thisRef.preferences.getLong(property.name, defaultValue)
            else -> throw UnsupportedOperationException("Not support for $property.name")
        } as T
    }

    override fun setValue(thisRef: PrefManager, property: KProperty<*>, value: T?) {
        val edit = thisRef.preferences.edit()
        when (value){
            is Boolean -> edit.putBoolean(property.name, value)
            is String -> edit.putString(property.name, value)
            is Float -> edit.putFloat(property.name, value)
            is Int -> edit.putInt(property.name, value)
            is Long -> edit.putLong(property.name, value)
        }
        edit.apply()
    }
}