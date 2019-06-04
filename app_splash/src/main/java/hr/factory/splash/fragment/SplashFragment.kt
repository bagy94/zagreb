package hr.factory.splash.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import hr.factory.base_module.fragment.BaseFragment
import hr.factory.base_module.navigation.NavCommand
import hr.factory.splash.R
import hr.factory.splash.presenter.SplashPresenter
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import org.koin.android.ext.android.inject
import java.util.concurrent.TimeUnit

class SplashFragment:BaseFragment<SplashPresenter>() {

    override val viewId: Int = R.layout.fragment_splash

    override val presenter: SplashPresenter by inject()

    lateinit var disposable:Disposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        disposable = Observable.interval(2, TimeUnit.SECONDS)
            .subscribe({
                val directions = SplashFragmentDirections.actionOpenLocations()
                navigate(NavCommand.To(directions))
            },
                { Log.d(SplashFragment::class.java.name, "On subscribe error")})
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.dispose()
    }
}