package hr.factory.home_location.location_list.presenter

import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.interactor.LocationInteractor
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.presenter.BasePresenter
import hr.factory.home_location.R
import hr.factory.home_location.location_list.view.LocationsView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

interface LocationsPresenter: BasePresenter {
    fun locationSelected(location:LocationRawItem)
}
class  LocationsPresenterImpl(private val mInteractor:LocationInteractor, private val mView: LocationsView):
    LocationsPresenter {

    private lateinit var mDisposable: Disposable

    override fun onStart() {
        val locations = mInteractor.getAllLocations()
        mDisposable = Observable.just(locations)
            .subscribeOn(Schedulers.newThread())
            .flatMap {
                val wrappers =
                    it.map { location -> AdapterDataWrapper(location, R.layout.item_location_home) }
                        .toList()
                Observable.just(wrappers)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mView.showLocations(it)
            }
    }

    override fun locationSelected(location: LocationRawItem) {
        mView.openLocationSingle(location.id)

    }
}