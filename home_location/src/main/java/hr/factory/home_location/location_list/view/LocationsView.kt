package hr.factory.home_location.location_list.view

import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.view.BaseView

interface LocationsView:BaseView{
    fun openLocationSingle(locationId:Int)
    fun showLocations(locationList: List<AdapterDataWrapper<LocationRawItem>>)
}