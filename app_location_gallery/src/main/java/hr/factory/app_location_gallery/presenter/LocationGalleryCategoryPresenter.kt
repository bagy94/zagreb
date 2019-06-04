package hr.factory.app_location_gallery.presenter

import hr.factory.app_location_gallery.R
import hr.factory.app_location_gallery.view.LocationGalleryCategoryView
import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.interactor.LocationInteractor
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.presenter.BasePresenter
import io.reactivex.Observable

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


interface LocationGalleryCategoryPresenter : BasePresenter {
    fun setLocationId(locationId: Int)

    fun handleClick(viewId:Int)

    fun imageSelected(image:GalleryRaw)
}

class LocationGalleryCategoryPresenterImpl(private val mView: LocationGalleryCategoryView, private val mInteractor: LocationInteractor) : LocationGalleryCategoryPresenter {

    private lateinit var mLocation: LocationRawItem

    private lateinit var mDisposable: Disposable

    override fun handleClick(viewId: Int) {
        when (viewId) {
            R.id.burgerMenu -> mView.back()
        }
    }

    override fun setLocationId(locationId: Int) {
        mDisposable = Observable.just(mInteractor.getById(locationId))
                .subscribeOn(Schedulers.newThread())
                .flatMap {
                    mLocation = it
                    val adapterWrappers = mutableListOf<AdapterDataWrapper<GalleryRaw>>()
                    for (item in it.galleryList){
                        adapterWrappers.add(AdapterDataWrapper(item))
                    }
                    Observable.just(adapterWrappers)
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    mView.showLocationImages(it)
                }
    }

    override fun imageSelected(image: GalleryRaw) {
        mView.openSingleImageGallery(mLocation.id,image.imageUrl)
    }

    override fun onViewDestroyed() {
        mDisposable.dispose()
    }
}