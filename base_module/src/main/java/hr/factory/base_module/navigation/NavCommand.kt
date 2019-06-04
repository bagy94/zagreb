package hr.factory.base_module.navigation

import androidx.navigation.NavDirections

sealed class NavCommand {
    data class To(val navDirections: NavDirections):NavCommand()
    object Back:NavCommand()
    data class BackTo(val destination:Int):NavCommand()
}