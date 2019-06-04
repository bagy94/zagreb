package hr.factory.app_send_postcard.presenter

import com.jakewharton.rxbinding3.InitialValueObservable
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent
import hr.factory.app_send_postcard.R
import hr.factory.app_send_postcard.model.MailDataWrapper
import hr.factory.app_send_postcard.view.SendPostcardView
import hr.factory.base_module.presenter.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import java.util.function.BiFunction

interface SendPostcardPresenter:BasePresenter{
    fun handleClick(viewId:Int, yourName:String?, friendsName:String, message:String)
    fun bindToUserInput(observableName: InitialValueObservable<TextViewTextChangeEvent>, observableFriendName: InitialValueObservable<TextViewTextChangeEvent>, observableMessage: InitialValueObservable<TextViewTextChangeEvent>)
}

class SendPostcardPresenterImpl(private val mView:SendPostcardView):SendPostcardPresenter{

    private val mDisposables:CompositeDisposable = CompositeDisposable()

    override fun handleClick(viewId: Int, yourName: String?, friendsName: String, message: String) {
        when(viewId){
            R.id.burgerMenu -> mView.back()
            R.id.sendPostcard -> {
                mView.makePostcard(MailDataWrapper(friendsName,message,yourName))
            }
        }
    }

    override fun bindToUserInput(observableName: InitialValueObservable<TextViewTextChangeEvent>, observableFriendName: InitialValueObservable<TextViewTextChangeEvent>, observableMessage: InitialValueObservable<TextViewTextChangeEvent>) {
        mDisposables.add(Observables
            .combineLatest(observableName,observableFriendName,observableMessage) { _, obs2, obs3 ->
                obs3.text.isNotEmpty() && obs2.text.isNotEmpty()
            }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mView.setEnabledSubmitButton(it)
            })
    }

    override fun onViewDestroyed() {
        if(!mDisposables.isDisposed){
            mDisposables.dispose()
        }
    }
}