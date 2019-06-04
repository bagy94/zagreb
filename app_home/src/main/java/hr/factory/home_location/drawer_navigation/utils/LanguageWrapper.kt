package hr.factory.home_location.drawer_navigation.utils

import android.content.Context
import hr.factory.base_module.utils.*

class LanguageWrapper(private val appContext: Context) {
    companion object {
        const val CURRENT_LANGUAGE = "Application.Language"
    }

    var isDifferentFromSystem:Boolean = false
        private set

    fun getCurrentLanguage(): SupportedLanguage {
        val defaultSystemLang = getSystemLanguage(appContext)
        val default = getSavedLanguage(appContext,defaultSystemLang)
        isDifferentFromSystem = default != defaultSystemLang
        return if(default == SupportedLanguage.CRO.symbol) SupportedLanguage.CRO
            else SupportedLanguage.EN
    }

    fun updateLanguage(lang: SupportedLanguage):Context = setNewLocale(appContext,lang.symbol)


    fun storeLanguage(lang: SupportedLanguage){
        saveCurrent(appContext,lang.symbol)
    }
}