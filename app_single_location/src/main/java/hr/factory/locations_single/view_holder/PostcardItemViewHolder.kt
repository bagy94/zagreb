package hr.factory.locations_single.view_holder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import hr.factory.base_module.constants.IMAGE_CORNER_RADIUS_5
import hr.factory.base_module.models.location_raw_item.NowAndThenGalleryRaw
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.view.BaseViewHolder
import hr.factory.locations_single.R
import kotlinx.android.synthetic.main.postcard_layout.view.*

class PostcardItemViewHolder(view:View):BaseViewHolder(view), View.OnClickListener {

    private lateinit var mItem:NowAndThenGalleryRaw
    private var isFrontShown:Boolean = true

    init {
        itemView.swapImage.setOnClickListener(this)
    }
    override fun bind(item: Any) {
        if (item is NowAndThenGalleryRaw) {
            mItem = item
            Glide.with(itemView)
                    .load(item.frontImageUrl)
                    .transform(CenterCrop(), RoundedCorners(IMAGE_CORNER_RADIUS_5.asDp()))
                    .into(itemView.postcardImage)
        }
    }

    fun getCurrentImageURL():String =
        if (isFrontShown)
            mItem.frontImageUrl
        else
            mItem.backImageUrl

    override fun onClick(v: View) {
        when(v.id){
            R.id.swapImage ->{
                onSwapImageClick()
            }
            R.id.map->{}
        }


    }
    private fun onSwapImageClick(){
        isFrontShown = if(isFrontShown){
            Glide.with(itemView)
                .load(mItem.backImageUrl)
                .into(itemView.postcardImage)
            false
        }else{
            Glide.with(itemView)
                .load(mItem.frontImageUrl)
                .into(itemView.postcardImage)
            true
        }
    }
}