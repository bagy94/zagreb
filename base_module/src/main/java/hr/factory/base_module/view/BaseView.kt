package hr.factory.base_module.view

import hr.factory.base_module.navigation.NavCommand

interface BaseView {
    fun navigate(navigationCommand:NavCommand)
    fun back(){
        navigate(NavCommand.Back)
    }
}