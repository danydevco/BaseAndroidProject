package co.edu.iub.baseandroidproject.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * En Kotlin, la palabra clave object se utiliza para declarar un singleton, lo que significa que
 * se crea una única instancia de la clase y esta instancia es accesible globalmente.
 * Cuando utilizas object en lugar de class, estás definiendo una clase que solo puede tener una
 * instancia y se inicializa cuando se accede por primera vez.
 */
object PreferencesManager {

    private const val PREFS_NAME = "IUB_PREFERENCES"

    private lateinit var sharedPreferences: SharedPreferences

    // Método para inicializar SharedPreferences automáticamente con el contexto de la aplicación
    private fun initialize(context: Context) {
        if (!::sharedPreferences.isInitialized) {
            sharedPreferences = context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        }
    }

    // Este método debe ser llamado antes de cualquier acceso a SharedPreferences
    private fun ensureInitialized(context: Context) {
        if (!::sharedPreferences.isInitialized) {
            initialize(context)
        }
    }

    // Métodos para guardar valores booleanos,
    fun saveBoolean(context: Context, key: String, value: Boolean) {
        ensureInitialized(context)
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    // Métodos para obtener valores booleanos,
    fun getBoolean(context: Context, key: String): Boolean {
        ensureInitialized(context)
        return sharedPreferences.getBoolean(key, false)
    }

    // Métodos para guardar valores enteros,
    fun saveInt(context: Context, key: String, value: Int) {
        ensureInitialized(context)
        sharedPreferences.edit().putInt(key, value).apply()
    }

    // Métodos para obtener valores enteros,
    fun getInt(context: Context, key: String): Int {
        ensureInitialized(context)
        return sharedPreferences.getInt(key, 0)
    }

    // Métodos para guardar valores de cadena,
    fun saveString(context: Context, key: String, value: String) {
        ensureInitialized(context)
        sharedPreferences.edit().putString(key, value).apply()
    }

    // Métodos para obtener valores de cadena,
    fun getString(context: Context, key: String): String {
        ensureInitialized(context)
        return sharedPreferences.getString(key, "") ?: ""
    }

}
