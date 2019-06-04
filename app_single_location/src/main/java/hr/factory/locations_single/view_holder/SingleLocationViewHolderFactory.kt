package hr.factory.locations_single.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hr.factory.base_module.adapter.RecyclerViewAdapter
import hr.factory.base_module.view.BaseViewHolder
import hr.factory.locations_single.R

class SingleLocationViewHolderFactory(private val onClickListener: View.OnClickListener):RecyclerViewAdapter.Factory {
    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = inflater.inflate(viewType,parent, false)
        return when(viewType){
            R.layout.postcard_layout-> { PostcardItemViewHolder(view) }
            else -> { LibraryViewHolder(view,onClickListener)}
        }
    }

    /*override fun getViewType(item: Any): Int {
        return when(item){
            is NowAndThenItem -> R.layout.item_now_and_then
            is AboutItem -> R.layout.item_about
            is LocationItem -> R.layout.item_location
            is NowAndThenGalleryRaw -> R.layout.item_post_card
            else-> R.layout.item_galery
        }
    }*/
}