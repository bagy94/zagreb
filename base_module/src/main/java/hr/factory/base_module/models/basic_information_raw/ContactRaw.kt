package hr.factory.base_module.models.basic_information_raw

import hr.factory.base_module.constants.EMPTY_STRING
import hr.factory.base_module.constants.STUB_IMAGE_ICON
import io.realm.RealmObject

/**
 * Created by domagoj on 23/11/17.
 */
open class ContactRaw(var title: String, var logoUrl: Int, var email: String, var telephone: String) : RealmObject() {
    constructor() : this(EMPTY_STRING, STUB_IMAGE_ICON, EMPTY_STRING, EMPTY_STRING)
}