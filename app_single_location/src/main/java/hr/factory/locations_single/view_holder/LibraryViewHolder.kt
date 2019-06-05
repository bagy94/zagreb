package hr.factory.locations_single.view_holder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import hr.factory.base_module.constants.IMAGE_CORNER_RADIUS_5
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.view.BaseViewHolder
import kotlinx.android.synthetic.main.item_galery.view.*

data class LibraryItem(val galleryList:List<GalleryRaw>)

class LibraryViewHolder(view: View, onClickListener: View.OnClickListener):BaseViewHolder(view) {

    init {
        itemView.galleryShowMore.setOnClickListener(onClickListener)
    }

    override fun bind(item: Any) {
        if(item is LibraryItem){
            val url1 = getFirstImagePreviewUrl(item.galleryList)
            val url2 = getSecondImagePreviewUrl(item.galleryList)
            val url3 = getThirdImagePreviewUrl(item.galleryList)
            Glide.with(itemView)
                    .load(url1)
                    .transform(CenterCrop(), RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp()))
                    .into(itemView.imagePreview1)
            Glide.with(itemView)
                    .load(url2)
                    .transform(CenterCrop(), RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp()))
                    .into(itemView.imagePreview2)
            Glide.with(itemView)
                    .load(url3)
                    .transform(CenterCrop(), RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp()))
                    .into(itemView.imagePreview3)
            itemView.gallerySize.text = "+${item.galleryList.size - 2}"
        }
    }
    private fun getFirstImagePreviewUrl(galleryList: List<GalleryRaw>) = galleryList.first().imageUrl

    private fun getSecondImagePreviewUrl(galleryList: List<GalleryRaw>):String {
        return if(galleryList.size > 1){
            galleryList[1].imageUrl
        }else{
            galleryList.first().imageUrl
        }
    }

    private fun getThirdImagePreviewUrl(galleryList: List<GalleryRaw>):String{
        return if(galleryList.size > 2){
            galleryList[2].imageUrl
        }else{
            getSecondImagePreviewUrl(galleryList)
        }
    }
}