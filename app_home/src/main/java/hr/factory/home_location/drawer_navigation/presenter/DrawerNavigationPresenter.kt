package hr.factory.home_location.drawer_navigation.presenter

import hr.factory.base_module.presenter.BasePresenter
import hr.factory.home_location.drawer_navigation.utils.LanguageWrapper
import hr.factory.base_module.utils.SupportedLanguage
import hr.factory.home_location.R
import hr.factory.home_location.drawer_navigation.view.DrawerNavigationView

interface DrawerNavigationPresenter:BasePresenter{
    fun changeLanguage(lang: SupportedLanguage)

    fun handleClick(viewId:Int)
}

class DrawerNavigationPresenterImpl(private val view: DrawerNavigationView, private val localeUtil: LanguageWrapper):
    DrawerNavigationPresenter {

    private lateinit var currentLanguage: SupportedLanguage


    override fun onStart() {
        currentLanguage = localeUtil.getCurrentLanguage()
        view.onLanguageChanged(currentLanguage, localeUtil.isDifferentFromSystem)
    }

    override fun changeLanguage(lang: SupportedLanguage) {
        if(currentLanguage != lang){
            localeUtil.storeLanguage(lang)
            localeUtil.updateLanguage(lang)
            view.onLanguageChanged(lang,true)
        }
    }

    override fun handleClick(viewId: Int) {
        when(viewId){
            R.id.actionCro -> changeLanguage(SupportedLanguage.CRO)
            R.id.actionEng -> changeLanguage(SupportedLanguage.EN)
            R.id.drawerActionAbout -> view.onActionAbout()
            R.id.drawerActionPostcards -> view.onPostcard()
            R.id.drawerActionTeam -> view.onActionTeam()
            R.id.mapFragment ->view.openMapView()
            R.id.locationsFragment->view.openLocationsView()
        }
    }
}