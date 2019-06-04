package hr.factory.home_location.drawer_navigation.view

import hr.factory.base_module.utils.SupportedLanguage

interface DrawerNavigationView{
    fun onLanguageChanged(lang: SupportedLanguage, reload:Boolean)
    fun onActionAbout()
    fun onActionTeam()
    fun onPostcard()
    fun openMapView()
    fun openLocationsView()
}