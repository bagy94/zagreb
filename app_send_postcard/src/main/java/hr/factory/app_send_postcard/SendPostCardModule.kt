package hr.factory.app_send_postcard

import hr.factory.app_send_postcard.presenter.SendPostcardPresenter
import hr.factory.app_send_postcard.presenter.SendPostcardPresenterImpl
import hr.factory.app_send_postcard.view.SendPostcardView
import org.koin.dsl.module

val sendPostcardModule = module {
    factory { (view:SendPostcardView)-> SendPostcardPresenterImpl(view) as SendPostcardPresenter}
}