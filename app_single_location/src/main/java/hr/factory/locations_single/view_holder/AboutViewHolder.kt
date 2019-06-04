package hr.factory.locations_single.view_holder

import android.view.View
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.item_about.view.*

data class AboutItem(val title:String,val description:String)

class AboutViewHolder(view: View):BaseViewHolder(view){

    override fun bind(item: Any) {
        if(item is AboutItem){
            itemView.locationAbout.setCollapsingText(item.description)
            itemView.locationName.text = item.title
        }
    }
}