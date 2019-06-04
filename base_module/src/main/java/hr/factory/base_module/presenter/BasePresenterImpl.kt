package hr.factory.base_module.presenter

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterImpl : BasePresenter{

    protected val mDisposables:CompositeDisposable by lazy { CompositeDisposable() }

    override fun onViewDestroyed() {
        if(!mDisposables.isDisposed){
            mDisposables.dispose()
        }
    }
}