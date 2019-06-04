package hr.factory.base_module.models.location_item_lat_lng_wrapper

import com.google.android.gms.maps.model.LatLng
import hr.factory.base_module.models.marker_option_location_bundle.MarkerOptionLocationBundle

/**
 * Created by domagoj on 01/11/17.
 */
class LocationItemLatLngWrapper(val markerOptionLocationList: ArrayList<MarkerOptionLocationBundle>, val presentWalkList: ArrayList<LatLng>, val historWalkList: ArrayList<LatLng>, val historicWalk: Boolean, val isHistory: Boolean) {
}