package hr.factory.base_module.interactor

import hr.factory.base_module.models.getLocations
import hr.factory.base_module.models.getLocationsById
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.models.location_raw_item.NowAndThenGalleryRaw
import io.realm.Realm

interface LocationInteractor{
    fun getAllLocations():List<LocationRawItem>

    fun getById(locationId:Int):LocationRawItem

    fun getGalleryRawFromRealm(locationRawItem: LocationRawItem):List<GalleryRaw>

    fun getNowAndThenGalleryFromRealm(locationRawItem: LocationRawItem):List<NowAndThenGalleryRaw>
}


class LocationInteractorImpl: LocationInteractor{

    override fun getAllLocations() : List<LocationRawItem> = getLocations()

    override fun getById(locationId: Int): LocationRawItem = getLocationsById(locationId)

    override fun getGalleryRawFromRealm(locationRawItem: LocationRawItem): List<GalleryRaw> {
        val realm = Realm.getDefaultInstance()
        realm.use {
            return it.copyFromRealm(locationRawItem.galleryList)
        }
    }

    override fun getNowAndThenGalleryFromRealm(locationRawItem: LocationRawItem): List<NowAndThenGalleryRaw> {
        val realm = Realm.getDefaultInstance()
        realm.use {
            return it.copyFromRealm(locationRawItem.nowAndThenGalleryList)
        }
    }
}