package hr.factory.base_module.models.custom_lat_long

import hr.factory.base_module.constants.EMPTY_COORDINATES
import hr.factory.base_module.constants.INIT_INT
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by domagoj on 01/11/17.
 */
open class CustomLatLong(var id: Int,  var latitude: Double, var longitude: Double) : RealmObject() {
    //TODO remove prim key one day when DB is finshed
    constructor() : this(INIT_INT, EMPTY_COORDINATES, EMPTY_COORDINATES)
}