package ru.skillbranch.skillarticles.viewmodels.base

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * @author Susev Sergey

Реализуй делегат ViewModelDelegate<T : ViewModel>(private val clazz: Class<T>, private val arg: Any?) : ReadOnlyProperty<FragmentActivity, T>
реализующий получение экземляра BaseViewModel соответствующего типа <T> с аргументами переданными вторым аргументом конструктора.
Пример:
val viewModel : TestViewModel by provideViewModel("test args")

Реализуй в классе BaseActivity инлайн функцию
internal inline fun provideViewModel(arg : Any?) : ViewModelDelegate - возвращающую экземпляр делегата ViewModelDelegate

 */
class ViewModelDelegate<T : ViewModel>(private val clazz: Class<T>, private val arg: Any?) :
    ReadOnlyProperty<FragmentActivity, T> {

    override fun getValue(thisRef: FragmentActivity, property: KProperty<*>): T {
        val vmFactory = ViewModelFactory(arg ?: Any())
        return ViewModelProviders.of(thisRef, vmFactory).get(clazz)
    }
}