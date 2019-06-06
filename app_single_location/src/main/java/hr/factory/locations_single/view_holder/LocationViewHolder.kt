package hr.factory.locations_single.view_holder

import android.view.View
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.item_location_single.view.*

data class LocationItem(val mapId:Int, val address:String,val latitude: Double,val longitude: Double)

class LocationViewHolder(view: View, onClickListener: View.OnClickListener):BaseViewHolder(view){

    init {
        itemView.openLocation.setOnClickListener(onClickListener)
    }

    override fun bind(item: Any) {
        if(item is LocationItem){
            itemView.locationAddress.text = item.address
            itemView.mapImage.setImageResource(item.mapId)
        }
    }
}