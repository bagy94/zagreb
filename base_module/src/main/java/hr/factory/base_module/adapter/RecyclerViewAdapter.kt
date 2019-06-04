package hr.factory.base_module.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.factory.base_module.view.BaseViewHolder

class RecyclerViewAdapter<T:Any>(data:List<AdapterDataWrapper<T>>? = null, private val mViewHolderFactory:Factory):RecyclerView.Adapter<BaseViewHolder>(){

    constructor(mViewHolderFactory:Factory):this(null,mViewHolderFactory)

    private val mData: MutableList<AdapterDataWrapper<T>> = mutableListOf()

    init {
        data?.let { setNewData(it) }
    }

    fun setNewData(data:List<AdapterDataWrapper<T>>){
        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return mViewHolderFactory.createViewHolder(inflater,parent,viewType)
    }


    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(mData[position].data)
    }

    override fun getItemViewType(position: Int): Int = mData[position].viewId

    interface Factory{
        fun createViewHolder(inflater:LayoutInflater, parent: ViewGroup, viewType:Int):BaseViewHolder
    }
}