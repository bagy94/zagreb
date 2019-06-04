package hr.factory.base_module.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun NavDirections.goWith(navController: NavController){
    navController.navigate(this)
}