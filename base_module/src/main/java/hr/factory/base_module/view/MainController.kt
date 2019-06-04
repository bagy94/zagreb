package hr.factory.base_module.view

import androidx.annotation.ColorRes

interface MainController {
    fun setStatusBarColor(@ColorRes colorRes:Int)

    fun setStatusBarVisibility(visible:Boolean)
}