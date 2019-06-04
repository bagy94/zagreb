package hr.factory.splash.di

import hr.factory.splash.presenter.SplashPresenter
import hr.factory.splash.presenter.SplashPresenterImpl
import org.koin.dsl.module

val splashModule = module {
    factory { SplashPresenterImpl() as SplashPresenter }
}