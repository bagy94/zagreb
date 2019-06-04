package hr.factory.app_location_gallery.presenter

import hr.factory.app_location_gallery.R
import hr.factory.app_location_gallery.view.SingleImageGalleryView
import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.interactor.LocationInteractor
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.presenter.BasePresenter
import hr.factory.base_module.utils.SupportedLanguage
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*

interface SingleImageGalleryPresenter:BasePresenter {
    fun handleClick(viewId:Int, currentVisibleItem:Int)

    fun setLocationId(locationId:Int)

    fun setSelectedImageUrl(imageUrl:String)
}

class SingleImageGalleryPresenterImpl(private val mView:SingleImageGalleryView, private val mInteractor:LocationInteractor, private val mLanguage: SupportedLanguage):SingleImageGalleryPresenter{

    private val mDisposable:CompositeDisposable = CompositeDisposable()

    private lateinit var mLocation:LocationRawItem

    override fun handleClick(viewId: Int, currentVisibleItem:Int) {
        when(viewId){
            R.id.burgerMenu->mView.back()
            R.id.openInDigitalLibrary -> {
                val imageUrl = getSelectedImageUrl(currentVisibleItem)
                if(imageUrl.isNotEmpty()){
                    mView.showCurrentImageOnWeb(imageUrl)
                }
            }
        }
    }

    override fun setLocationId(locationId: Int) {
        mLocation = mInteractor.getById(locationId)
        mDisposable.addAll(Observable.just(mLocation)
                .subscribeOn(Schedulers.newThread())
                .flatMap {
                    val wrappers = it.galleryList.map { galleryItem -> AdapterDataWrapper(galleryItem)}.toList()
                    Observable.just(wrappers)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    if(mLanguage == SupportedLanguage.CRO){
                        mView.showLocationName(mLocation.titleHr!!.string)
                    }else{
                        mView.showLocationName(mLocation.titleEn!!.string)
                    }
                    mView.showLocationGallery(it)
                })
    }

    override fun setSelectedImageUrl(imageUrl: String) {
        mDisposable.addAll(Observable.just(mLocation)
                .observeOn(Schedulers.computation())
                .flatMap { location ->
                    val position = location.galleryList.indexOfFirst { it.imageUrl == imageUrl }
                    Observable.just(position)
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    mView.showSelectedImage(it)
                })
    }

    override fun onViewDestroyed() {
        if(!mDisposable.isDisposed){
            mDisposable.dispose()
        }
    }

    private fun getSelectedImageUrl(currentVisibleItem: Int):String = mLocation.galleryList[currentVisibleItem]?.imageUrl ?: ""
}