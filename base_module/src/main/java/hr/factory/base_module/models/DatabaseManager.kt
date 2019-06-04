package hr.factory.base_module.models

import android.content.Context
import hr.factory.base_module.R
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.utils.createDummyLocationListCroatian
import io.realm.ImportFlag
import io.realm.Realm
import java.io.File
import java.io.FileOutputStream

fun getLocations():List<LocationRawItem>{
    val realm = Realm.getDefaultInstance()
    realm.use {
        return realm.copyFromRealm(
            realm.where(LocationRawItem::class.java).findAllAsync()
        )
    }
}

fun getLocationsById(locationId:Int):LocationRawItem{
    val realm = Realm.getDefaultInstance()
    realm.use {
        val item = it.where(LocationRawItem::class.java).equalTo("id",locationId).findFirst()
        item?.let {
            return realm.copyFromRealm(item)
        }
    }
    return LocationRawItem()
}

fun copyBundledRealmFile(){
    var content = createDummyLocationListCroatian()
    var realm = Realm.getDefaultInstance()
    realm.use {
        it.executeTransactionAsync {rm->
            rm.insertOrUpdate(content)
        }
    }
}