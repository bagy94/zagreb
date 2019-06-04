package hr.factory.base_module.models.basic_information_raw

import hr.factory.base_module.constants.PRIMARY_KEY_INT
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by domagoj on 23/11/17.
 */
open class BasicInformationRaw(@PrimaryKey var id: Int = PRIMARY_KEY_INT, var team: BasicInformationItemRaw?, var investors: BasicInformationItemRaw?, var development: BasicInformationItemRaw?, var about: BasicInformationItemRaw?) : RealmObject() {
    constructor() : this(PRIMARY_KEY_INT, BasicInformationItemRaw(), BasicInformationItemRaw(), BasicInformationItemRaw(), BasicInformationItemRaw())
}