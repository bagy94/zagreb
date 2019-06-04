package hr.factory.base_module.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.factory.base_module.navigation.NavCommand
import hr.factory.base_module.presenter.BasePresenter
import hr.factory.base_module.view.BaseView
import hr.factory.base_module.view.MainController
import org.koin.core.KoinComponent

abstract class BaseFragment<PRESENTER:BasePresenter>: Fragment(), BaseView, KoinComponent{

    protected abstract val presenter:PRESENTER

    protected var mMainController:MainController? = null

    abstract val viewId:Int

    protected open val mNavController by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View  =
        inflater.inflate(viewId, container, false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainController){
            mMainController = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun navigate(navigationCommand: NavCommand) {
        when(navigationCommand){
            is NavCommand.To -> mNavController.navigate(navigationCommand.navDirections)
            is NavCommand.Back -> mNavController.navigateUp()
            is NavCommand.BackTo -> mNavController.popBackStack(navigationCommand.destination,false)
        }
    }
}