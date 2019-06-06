package hr.factory.locations_single.view_holder

import android.view.View
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import hr.factory.base_module.constants.IMAGE_CORNER_RADIUS_5
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.utils.setImageFromUrlWithGlide
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.item_now_and_then.view.*

data class NowAndThenItem(val nowImageUrl:String,val thenImageUrl:String)

class NowAndThenViewHolder(view: View):BaseViewHolder(view){
    override fun bind(item: Any) {
        if (item is NowAndThenItem)
            itemView.nowAndThen.setImageFromUrlWithGlide(
                item.nowImageUrl,
                FitCenter(),
                RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp())
            )

    }
}