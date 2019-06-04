package hr.factory.home_location.maps.presenter

import hr.factory.base_module.interactor.LocationInteractor
import hr.factory.base_module.presenter.BasePresenter
import hr.factory.base_module.presenter.BasePresenterImpl
import hr.factory.home_location.maps.view.MapView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers

interface MapPresenter:BasePresenter{
    fun onMapsReady()

    fun onHistoricalWalk(isOn:Boolean)
}
class MapPresenterImpl(private val mView:MapView, private val mInteractor:LocationInteractor):BasePresenterImpl(),MapPresenter {

    override fun onMapsReady() {
        mView.initMapSettings()
        mDisposables.addAll(
            Observable.just(mInteractor.getAllLocations())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    mView.showLocationsMarkers(it)
                })
    }

    override fun onHistoricalWalk(isOn: Boolean) {
        if(isOn){
            mView.showOldMapOverlay()
        }else{
            mView.hideOldMapOverlay()
        }
    }
}