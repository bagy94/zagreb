package hr.factory.base_module.view

import android.view.View

fun View.toggleSelectWith(vararg  views:View){
    for (view in views){
        view.isSelected = isSelected
    }
    isSelected = !isSelected
}
fun View.setIsVisible(visibility:Boolean){
    this.visibility = if(visibility) View.VISIBLE else View.GONE
}