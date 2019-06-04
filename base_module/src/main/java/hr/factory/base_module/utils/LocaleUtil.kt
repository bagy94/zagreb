package hr.factory.base_module.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.preference.PreferenceManager
import java.util.*

private const val CURRENT_LANGUAGE = "Application.Language"

fun getSystemLanguage(context: Context):String{
    return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
        context.resources.configuration.locales[0].language
    }else{
        context.resources.configuration.locale.language
    }
}

fun setLocale(context: Context):Context = setNewLocale(context, getSavedLanguage(context, getSystemLanguage(context)))

fun setNewLocale(context: Context, lang:String):Context{
    saveCurrent(context,lang)
    val locale = Locale(lang)
    Locale.setDefault(locale)
    with(context.resources){
        val config = Configuration(configuration)
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            config.setLocale(locale)
            updateConfiguration(config,displayMetrics)
            context.createConfigurationContext(config)
        }else{
            config.locale = locale
            updateConfiguration(config,displayMetrics)
            context
        }
    }
}

fun saveCurrent(context: Context,lang:String){
    val pref = PreferenceManager.getDefaultSharedPreferences(context)
    pref.edit().apply {
        putString(CURRENT_LANGUAGE,lang)
    }.apply()
}
fun getSavedLanguage(context: Context, defaultLang:String):String{
    val prefs = PreferenceManager.getDefaultSharedPreferences(context)
    return prefs.getString(CURRENT_LANGUAGE,defaultLang)!!
}

fun getCurrentLanguage(appContext:Context):SupportedLanguage {
    val defaultSystemLang = getSystemLanguage(appContext)
    val default = getSavedLanguage(appContext,defaultSystemLang)
    return if(default == SupportedLanguage.CRO.symbol) SupportedLanguage.CRO
    else SupportedLanguage.EN
}