package hr.factory.home_location

import hr.factory.base_module.interactor.LocationInteractor
import hr.factory.base_module.interactor.LocationInteractorImpl
import hr.factory.home_location.drawer_navigation.presenter.DrawerNavigationPresenter
import hr.factory.home_location.drawer_navigation.presenter.DrawerNavigationPresenterImpl
import hr.factory.home_location.location_list.presenter.LocationsPresenter
import hr.factory.home_location.location_list.presenter.LocationsPresenterImpl
import hr.factory.home_location.drawer_navigation.utils.LanguageWrapper
import hr.factory.home_location.drawer_navigation.view.DrawerNavigationView
import hr.factory.home_location.location_list.view.LocationsView
import hr.factory.home_location.maps.presenter.MapPresenter
import hr.factory.home_location.maps.presenter.MapPresenterImpl
import hr.factory.home_location.maps.view.MapView
import org.koin.dsl.module

val homeLocationListModule = module {
    factory {  LocationInteractorImpl() as LocationInteractor }
    factory {  (view: LocationsView)->
        LocationsPresenterImpl(
            get(),
            view
        ) as LocationsPresenter
    }
    factory { LanguageWrapper(get()) }
    factory { (view: DrawerNavigationView)-> DrawerNavigationPresenterImpl(view,get()) as DrawerNavigationPresenter }
    factory { (view:MapView)-> MapPresenterImpl(view,get()) as MapPresenter}
}