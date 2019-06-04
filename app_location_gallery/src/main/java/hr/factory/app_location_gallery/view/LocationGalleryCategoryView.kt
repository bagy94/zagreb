package hr.factory.app_location_gallery.view

import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.view.BaseView

interface LocationGalleryCategoryView:BaseView {
    fun showLocationImages(imageList: List<AdapterDataWrapper<GalleryRaw>>)

    fun openSingleImageGallery(locationId:Int, imageUrl:String)
}