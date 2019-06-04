package hr.factory.home_location.maps.view

import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.view.BaseView

interface MapView:BaseView {
    fun showLocationsMarkers(locations:List<LocationRawItem>)

    fun initMapSettings()

    fun showOldMapOverlay()

    fun hideOldMapOverlay()
}