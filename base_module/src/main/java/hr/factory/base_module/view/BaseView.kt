package hr.factory.base_module.view

import androidx.navigation.NavController
import hr.factory.base_module.navigation.NavCommand

interface BaseView {
    fun navigate(navigationCommand:NavCommand, navController: NavController? =null )
    fun back(){
        navigate(NavCommand.Back)
    }
}