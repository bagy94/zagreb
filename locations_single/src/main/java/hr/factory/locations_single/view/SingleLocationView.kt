package hr.factory.locations_single.view

import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.view.BaseView

interface SingleLocationView:BaseView {
    fun showLocationInfo(locationData:List<AdapterDataWrapper<Any>>)

    fun onShareClick(message:String, imageLink:String)

    fun openLocationGallery(locationId : Int)

    fun openNavigationIntent(lat:Double, long:Double, mode:String? = null)
}