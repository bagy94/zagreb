package hr.factory.app_project_info.fragment

import androidx.navigation.fragment.navArgs
import hr.factory.app_project_info.R
import hr.factory.app_project_info.presenter.StaticAboutPresenter
import hr.factory.app_project_info.view.StaticAboutView
import hr.factory.base_module.fragment.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class StaticAboutFragment:BaseFragment<StaticAboutPresenter> (), StaticAboutView{

    override val viewId: Int = R.layout.fragment_about_project

    override val presenter: StaticAboutPresenter by inject {  parametersOf(this)}
}