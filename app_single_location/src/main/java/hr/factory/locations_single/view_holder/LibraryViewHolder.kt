package hr.factory.locations_single.view_holder

import android.view.View
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import hr.factory.base_module.constants.IMAGE_CORNER_RADIUS_5
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.utils.setImageFromUrlWithGlide
import hr.factory.base_module.view.BaseViewHolder
import hr.factory.locations_single.R
import kotlinx.android.synthetic.main.item_galery.view.*

data class LibraryItem(val img1Url: String, val img2Url: String, val img3Url: String, val size: Int)

class LibraryViewHolder(view: View, onClickListener: View.OnClickListener):BaseViewHolder(view) {

    init {
        with(itemView) {
            galleryShowMore.setOnClickListener(onClickListener)
            imagePreview1.setOnClickListener(onClickListener)
            imagePreview2.setOnClickListener(onClickListener)
        }
    }

    override fun bind(item: Any) {
        if(item is LibraryItem){
            with(itemView) {
                imagePreview1.setImageFromUrlWithGlide(
                    item.img1Url,
                    CenterCrop(),
                    RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp())
                )
                imagePreview2.setImageFromUrlWithGlide(
                    item.img2Url,
                    CenterCrop(),
                    RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp())
                )
                imagePreview3.setImageFromUrlWithGlide(
                    item.img3Url,
                    CenterCrop(),
                    RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp())
                )
                gallerySize.text = resources.getString(R.string.gallery_size_placeholder, item.size)
            }
        }
    }
}