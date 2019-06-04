package hr.factory.app_project_info.presenter

import hr.factory.app_project_info.view.StaticAboutView
import hr.factory.base_module.presenter.BasePresenter

interface StaticAboutPresenter:BasePresenter{

}


class StaticAboutPresenterImpl (private val mView:StaticAboutView): StaticAboutPresenter {

}