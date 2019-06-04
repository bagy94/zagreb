package hr.factory.base_module.models.location_raw_item

import hr.factory.base_module.constants.EMPTY_STRING
import io.realm.RealmObject

/**
 * Created by domagoj on 15/11/17.
 */
open class NowAndThenGalleryRaw(var frontImageUrl: String, var backImageUrl: String, var link: String) : RealmObject(){
    constructor() : this(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING)
}