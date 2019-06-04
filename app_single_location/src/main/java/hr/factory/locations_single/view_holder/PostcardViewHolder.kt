package hr.factory.locations_single.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.adapter.RecyclerViewAdapter
import hr.factory.base_module.constants.ITEM_SPACING_5
import hr.factory.base_module.custom_view.SpaceItemDecorator
import hr.factory.base_module.models.location_raw_item.NowAndThenGalleryRaw
import hr.factory.base_module.utils.asDp
import hr.factory.base_module.view.BaseViewHolder
import hr.factory.locations_single.R
import kotlinx.android.synthetic.main.item_post_card.view.*

data class PostcardItem(val imageList:List<NowAndThenGalleryRaw>)


class PostcardViewHolder(v: View, private val onClickListener: OnSendPostcardClickListener):BaseViewHolder(v), View.OnClickListener, RecyclerViewAdapter.Factory {

    private lateinit var mCurrentItem:PostcardItem

    init {
        itemView.sendPostcard.setOnClickListener{
            val manager = itemView.postcardHolder.layoutManager as LinearLayoutManager
            val currentPosition = manager.findFirstCompletelyVisibleItemPosition()
            val viewHolder = itemView.postcardHolder.findViewHolderForAdapterPosition(currentPosition) as PostcardItemViewHolder
            val url = viewHolder.getCurrentImageURL()
            onClickListener.onSendPostcardClickListener(url)
        }
    }

    interface OnSendPostcardClickListener{
        fun onSendPostcardClickListener(imageUrl:String)
    }

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder =
        PostcardItemViewHolder(inflater.inflate(R.layout.postcard_layout,parent,false))


    override fun bind(item: Any) {
        if(item is PostcardItem){
            mCurrentItem = item
            val content = wrapContent(item.imageList)
            val adapter = RecyclerViewAdapter(content, this)
            val snapHolder = PagerSnapHelper()
            snapHolder.attachToRecyclerView(itemView.postcardHolder)
            itemView.postcardHolder.addItemDecoration(SpaceItemDecorator(ITEM_SPACING_5.asDp(),false))
            itemView.postcardHolder.adapter = adapter
        }
    }

    override fun onClick(v: View?) {

    }
    private fun wrapContent(data:List<NowAndThenGalleryRaw>):List<AdapterDataWrapper<NowAndThenGalleryRaw>>{
        val wrappers = mutableListOf<AdapterDataWrapper<NowAndThenGalleryRaw>>()
        for(item in data){
            wrappers.add(AdapterDataWrapper(item, R.layout.postcard_layout))
        }
        return wrappers
    }
}