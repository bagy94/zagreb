package hr.factory.base_module.adapter

open class AdapterDataWrapper<T>(val data:T, val viewId:Int = 0)

//class AdapterCollectionWrapper<T>(data:List<T>,viewId: Int = 0):AdapterDataWrapper<List<T>>(data,viewId)