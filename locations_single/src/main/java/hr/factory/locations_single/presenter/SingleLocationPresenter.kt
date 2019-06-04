package hr.factory.locations_single.presenter

import hr.factory.base_module.adapter.AdapterDataWrapper
import hr.factory.base_module.interactor.LocationInteractor
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.models.location_raw_item.NowAndThenGalleryRaw
import hr.factory.base_module.presenter.BasePresenter
import hr.factory.base_module.utils.SupportedLanguage
import hr.factory.locations_single.R
import hr.factory.locations_single.view.SingleLocationView
import hr.factory.locations_single.view_holder.*

interface SingleLocationPresenter : BasePresenter {
    fun setLocationId(locationId: Int)

    fun handleClick(viewId:Int)
}

class SingleLocationPresenterImpl(private val mView: SingleLocationView, private val mInteractor: LocationInteractor, private val language: SupportedLanguage) : SingleLocationPresenter {

    private lateinit var location:LocationRawItem

    override fun setLocationId(locationId: Int) {
        location = mInteractor.getById(locationId)
        val data = mutableListOf<AdapterDataWrapper<Any>>()
        data.add(AdapterDataWrapper(convertToNowAndThenItem(location), R.layout.item_now_and_then))
        data.add(AdapterDataWrapper(convertToAboutItem(location), R.layout.item_about))
        data.add(AdapterDataWrapper(convertToPostcard(location), R.layout.item_post_card))
        data.add(AdapterDataWrapper(convertToGallery(location), R.layout.item_galery))
        data.add(AdapterDataWrapper(convertToLocation(location), R.layout.item_location))
        mView.showLocationInfo(data)
    }

    override fun handleClick(viewId: Int) {
        when(viewId){
            R.id.openLocation ->{ mView.openNavigationIntent(location.latitude,location.longitude)}
            R.id.galleryShowMore -> mView.openLocationGallery(location.id)
            R.id.burgerMenu -> mView.back()
            R.id.toolbarMenu->
                if(language == SupportedLanguage.CRO)
                    mView.onShareClick(location.descriptionHr!!.string,location.imageNowUrl)
                else
                    mView.onShareClick(location.descriptionEn!!.string,location.imageNowUrl)
        }
    }

    private fun convertToAboutItem(location: LocationRawItem): AboutItem {
        return when (language) {
            SupportedLanguage.CRO -> {
                AboutItem(location.titleHr!!.string, location.descriptionHr!!.string)
            }
            else -> {
                AboutItem(location.titleEn!!.string, location.descriptionEn!!.string)
            }
        }
    }

    private fun convertToNowAndThenItem(location: LocationRawItem): NowAndThenItem = NowAndThenItem(nowImageUrl = location.imageNowUrl, thenImageUrl = location.imageAfterUrl)

    private fun convertToPostcard(location: LocationRawItem): PostcardItem {
        val list = mutableListOf<NowAndThenGalleryRaw>()
        for (item in location.nowAndThenGalleryList) {
            list.add(item)
        }
        return PostcardItem(list)
    }

    private fun convertToGallery(location: LocationRawItem): LibraryItem {
        val list = mutableListOf<GalleryRaw>()
        for (item in location.galleryList) {
            list.add(item)
        }
        return LibraryItem(list)
    }

    private fun convertToLocation(location: LocationRawItem): LocationItem {
        return with(location) {
            LocationItem(mapId, address, latitude, longitude)
        }
    }
}