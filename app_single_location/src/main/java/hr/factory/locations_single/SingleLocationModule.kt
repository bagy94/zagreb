package hr.factory.locations_single

import hr.factory.locations_single.presenter.SingleLocationPresenter
import hr.factory.locations_single.presenter.SingleLocationPresenterImpl
import hr.factory.locations_single.view.SingleLocationView
import org.koin.dsl.module

val singleLocationModule = module {
    factory {  (view: SingleLocationView)-> SingleLocationPresenterImpl(view, get(), get()) as SingleLocationPresenter }
}