package hr.factory.base_module.models.location_raw_item

import hr.factory.base_module.constants.EMPTY_STRING
import io.realm.RealmObject

/**
 * Created by domagoj on 26/10/17.
 */
open class StringLocale(var string: String) : RealmObject() {
    constructor(): this(EMPTY_STRING)
}