package hr.factory.app_location_gallery.view_holder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import hr.factory.base_module.constants.IMAGE_CORNER_RADIUS_5
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.item_single_gallery.view.*

class SingleImageViewHolder(view:View):BaseViewHolder(view) {

    override fun bind(item: Any) {
        if(item is GalleryRaw){
            Glide.with(itemView)
                    .load(item.imageUrl)
                    .transform(CenterCrop(),RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp()))
                    .into(itemView.singleGalleryImage)
        }
    }
}