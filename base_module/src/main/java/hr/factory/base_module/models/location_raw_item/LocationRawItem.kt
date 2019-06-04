package hr.factory.base_module.models.location_raw_item

import hr.factory.base_module.constants.*
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by domagoj on 26/10/17.
 */
open class LocationRawItem(@PrimaryKey var id: Int, var titleHr: StringLocale?, var titleEn: StringLocale?, var descriptionHr: StringLocale?,
                           var descriptionEn: StringLocale?, var address: String, var latitude: Double, var longitude: Double, var pinId: Int, var imageNowUrl: String, var imageAfterUrl: String,
                           var mapId: Int, var nowAndThenGalleryList: RealmList<NowAndThenGalleryRaw>, var galleryList: RealmList<GalleryRaw>) : RealmObject() {
    constructor() : this(INIT_INT, StringLocale(), StringLocale(), StringLocale(), StringLocale(), EMPTY_STRING, EMPTY_COORDINATES, EMPTY_COORDINATES, STUB_PIN_ICON, EMPTY_STRING, EMPTY_STRING, STUB_IMAGE_ICON, RealmList<NowAndThenGalleryRaw>(), RealmList<GalleryRaw>())
}