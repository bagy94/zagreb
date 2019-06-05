package hr.factory.home_location.maps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.utils.SupportedLanguage
import hr.factory.home_location.R
import kotlinx.android.synthetic.main.view_maps_marker.view.*

class MarkerInfoWindowAdapter(
    private val context: Context,
    private val language: SupportedLanguage
) : GoogleMap.InfoWindowAdapter {

    override fun getInfoContents(p0: Marker?): View? = null

    override fun getInfoWindow(p0: Marker?): View? {
        p0?.let {
            val uiData = it.tag as LocationRawItem
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.view_maps_marker,null)
            view.locName.text = if (language == SupportedLanguage.CRO)
                uiData.titleHr!!.string
            else
                uiData.titleEn!!.string
            return view
        }
        return null
    }
}