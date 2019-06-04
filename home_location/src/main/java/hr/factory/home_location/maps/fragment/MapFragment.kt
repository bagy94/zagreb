package hr.factory.home_location.maps.fragment

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import hr.factory.base_module.constants.MAPS_MIN_ZOOM_LEVEL
import hr.factory.base_module.constants.PERMISSION_LOCATION
import hr.factory.base_module.fragment.BaseFragment
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.utils.SupportedLanguage
import hr.factory.home_location.R
import hr.factory.home_location.drawer_navigation.fragment.DrawerNavigationViewFragmentDirections
import hr.factory.home_location.maps.adapter.MarkerInfoWindowAdapter
import hr.factory.home_location.maps.presenter.MapPresenter
import hr.factory.home_location.maps.ui.MapMarkerUI
import hr.factory.home_location.maps.view.MapView
import kotlinx.android.synthetic.main.fragment_map.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MapFragment:BaseFragment<MapPresenter>(), MapView, OnMapReadyCallback, CompoundButton.OnCheckedChangeListener,
    GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {

    override val viewId: Int = R.layout.fragment_map

    override val presenter: MapPresenter by inject { parametersOf(this)}

    private val mLanguage:SupportedLanguage by inject()

    private lateinit var mGoogleMap:GoogleMap

    private var mOldOverlay:GroundOverlay? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(ContextCompat.checkSelfPermission(activity!!,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(activity!!,android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_LOCATION)
        }else{
            initMap()
        }
        mapsView.onCreate(savedInstanceState)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
        presenter.onMapsReady()
        historicalMap.setOnCheckedChangeListener(this)
        mGoogleMap.setOnInfoWindowClickListener(this)
        mGoogleMap.setOnMarkerClickListener(this)
        mGoogleMap.setOnMapClickListener(this)
    }

    override fun initMapSettings() {
        val bounds = LatLngBounds(LatLng( 45.808398, 15.969395), LatLng(45.816317, 15.983627))
        mGoogleMap.setMinZoomPreference(MAPS_MIN_ZOOM_LEVEL)
        mGoogleMap.setLatLngBoundsForCameraTarget(bounds)
        mGoogleMap.uiSettings.isCompassEnabled = false
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds,0))

    }

    override fun showLocationsMarkers(locations: List<LocationRawItem>) {
        locations.forEach {
            val markerOptions:MarkerOptions = createMarkerFromLocation(it)
            val marker = mGoogleMap.addMarker(markerOptions)
            marker.tag =
                if(mLanguage == SupportedLanguage.CRO)
                    MapMarkerUI(it.titleHr!!.string, it.id)
                else
                    MapMarkerUI(it.titleEn!!.string,it.id)

        }
        mGoogleMap.setInfoWindowAdapter(MarkerInfoWindowAdapter(context!!))
    }

    override fun onInfoWindowClick(p0: Marker?) {
        p0?.let {
            val data = it.tag as MapMarkerUI
            val directions = DrawerNavigationViewFragmentDirections.actionOpenSingleLocation(data.locationId)
            Navigation.findNavController(activity!!, R.id.drawer).navigate(directions)
        }
    }
    override fun onMarkerClick(p0: Marker?): Boolean {
       // sendPostcard.visibility = View.VISIBLE
        return false
    }
    override fun onMapClick(p0: LatLng?) {
       // sendPostcard.visibility = View.GONE
    }


    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        presenter.onHistoricalWalk(isChecked)
    }

    override fun showOldMapOverlay() {
        val groundOverlay = GroundOverlayOptions()
        val bounds = LatLngBounds(LatLng(45.802806, 15.959523),LatLng(45.821457, 15.990701))
        groundOverlay.image(BitmapDescriptorFactory.fromResource(R.drawable.old_overlay))
        groundOverlay.positionFromBounds(bounds)
        mOldOverlay = mGoogleMap.addGroundOverlay(groundOverlay)
    }

    override fun hideOldMapOverlay() {
        mOldOverlay?.remove()
    }


    override fun onResume() {
        super.onResume()
        mapsView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapsView.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapsView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        mapsView?.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapsView.onLowMemory()
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults.isNotEmpty()){
            if(!grantResults.any { it != PackageManager.PERMISSION_GRANTED }){
                initMap()
            }
        }
    }

    private fun initMap(){
        mapsView.getMapAsync(this)
    }
    private fun createMarkerFromLocation(location:LocationRawItem):MarkerOptions{
        val position = LatLng(location.latitude,location.longitude)
        return MarkerOptions().position(position).icon(BitmapDescriptorFactory.fromResource(location.pinId))
    }
}