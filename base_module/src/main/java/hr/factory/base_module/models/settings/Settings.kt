package hr.factory.base_module.models.settings

import hr.factory.base_module.constants.LANGUAGE_ENGLISH
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by domagoj on 23/10/17.
 */
open class Settings(@PrimaryKey var id: Int = 0, var language: Int, var isHistory: Boolean = false, var historicWalk: Boolean = false) : RealmObject() {
    constructor() : this(0, LANGUAGE_ENGLISH, false, false)
}