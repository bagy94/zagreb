package hr.factory.base_module.models.location_raw_item

import hr.factory.base_module.constants.EMPTY_STRING
import io.realm.RealmObject

/**
 * Created by domagoj on 16/11/17.
 */
open class GalleryRaw(var imageUrl: String, var imageBack: String, var digitalUrl: String) : RealmObject() {
    constructor() : this(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING)
}