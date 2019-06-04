package hr.factory.base_module.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import hr.factory.base_module.R
import hr.factory.base_module.view.toggleSelectWith
import kotlinx.android.synthetic.main.bottom_bar.view.*

enum class BottomBarItem{
    Maps, Locations
}

class BottomBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    var selectedItem:BottomBarItem = BottomBarItem.Maps
        set(value) {
            field = value
            when( value){
                BottomBarItem.Maps -> setMapsSelected()
                else -> setLocationsSelected()
            }
        }

    init{
        View.inflate(context, R.layout.bottom_bar,this)
    }

    fun setOnItemsClickListener(onClickListener: OnClickListener){
        mapFragment.setOnClickListener(onClickListener)
        locations.setOnClickListener(onClickListener)
    }

    private fun setMapsSelected(){
        mapFragment.toggleSelectWith(locations)
    }
    private fun setLocationsSelected(){
        locations.toggleSelectWith(mapFragment)
    }
}