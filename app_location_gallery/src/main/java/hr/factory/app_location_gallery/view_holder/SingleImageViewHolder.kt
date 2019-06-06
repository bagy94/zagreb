package hr.factory.app_location_gallery.view_holder

import android.view.View
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import hr.factory.base_module.constants.IMAGE_CORNER_RADIUS_5
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.utils.setImageFromUrlWithGlide
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.item_single_gallery.view.*

class SingleImageViewHolder(view:View):BaseViewHolder(view) {

    override fun bind(item: Any) {
        if(item is GalleryRaw){
            //TODO Bottom image radius not working
            itemView.singleGalleryImage.setImageFromUrlWithGlide(
                item.imageUrl,
                FitCenter(),
                RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp())
            )
        }
    }
}