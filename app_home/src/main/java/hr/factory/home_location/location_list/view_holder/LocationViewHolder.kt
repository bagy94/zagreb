package hr.factory.home_location.location_list.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import hr.factory.base_module.adapter.RecyclerViewAdapter
import hr.factory.base_module.constants.IMAGE_CORNER_RADIUS_5
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.utils.SupportedLanguage
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.location_item.view.*

class LocationViewHolder(view: View, private val mClickListener: OnLocationClickListener, private val mLanguage:SupportedLanguage) : BaseViewHolder(view){

    interface OnLocationClickListener{
        fun onLocationSelected(location: LocationRawItem)
    }

    private lateinit var mLocation:LocationRawItem

    init {
        view.setOnClickListener { mClickListener.onLocationSelected(mLocation) }
    }

    override fun bind(item: Any) {
        if(item is LocationRawItem){
            bindLocation(item)
        }
    }
    private fun bindLocation(location:LocationRawItem){
        mLocation = location
        itemView.locationName.text = if(mLanguage == SupportedLanguage.CRO){
            location.titleHr!!.string
        }else{
            location.titleEn!!.string
        }
        itemView.locationAddress.text = location.address
        Glide.with(itemView)
            .load(location.imageNowUrl)
            .transform(FitCenter(), RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp()))
            .into(itemView.locationImage)
    }
}