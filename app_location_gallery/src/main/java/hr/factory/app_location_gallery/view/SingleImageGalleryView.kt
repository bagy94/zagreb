package hr.factory.app_location_gallery.view

import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.view.BaseView

interface SingleImageGalleryView:BaseView {
    fun showLocationGallery(gallery:List<AdapterDataWrapper<GalleryRaw>>)

    fun showSelectedImage(selectedImagePosition:Int)

    fun showLocationName(locationTitle:String)

    fun showCurrentImageOnWeb(imageUrl:String)
}