package hr.factory.app_location_gallery

import hr.factory.app_location_gallery.presenter.LocationGalleryCategoryPresenter
import hr.factory.app_location_gallery.presenter.LocationGalleryCategoryPresenterImpl
import hr.factory.app_location_gallery.presenter.SingleImageGalleryPresenter
import hr.factory.app_location_gallery.presenter.SingleImageGalleryPresenterImpl
import hr.factory.app_location_gallery.view.LocationGalleryCategoryView
import hr.factory.app_location_gallery.view.SingleImageGalleryView
import org.koin.dsl.module

val locationGalleryModule = module {
    factory { (view:LocationGalleryCategoryView)-> LocationGalleryCategoryPresenterImpl(view,get()) as LocationGalleryCategoryPresenter}
    factory { (view: SingleImageGalleryView) -> SingleImageGalleryPresenterImpl(view,get(),get()) as SingleImageGalleryPresenter}
}