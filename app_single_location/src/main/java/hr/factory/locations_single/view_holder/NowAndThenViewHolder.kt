package hr.factory.locations_single.view_holder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import hr.factory.base_module.models.location_raw_item.NowAndThenGalleryRaw
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.item_now_and_then.view.*

data class NowAndThenItem(val nowImageUrl:String,val thenImageUrl:String)

class NowAndThenViewHolder(view: View):BaseViewHolder(view){
    override fun bind(item: Any) {
        if(item is NowAndThenItem){
            Glide.with(itemView)
                    .load(item.nowImageUrl)
                    .transform(FitCenter())
                    .into(itemView.nowAndThen)
        }
    }
}