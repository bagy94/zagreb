package hr.factory.base_module.models.basic_information_raw

import hr.factory.base_module.constants.EMPTY_STRING
import hr.factory.base_module.constants.STUB_IMAGE_ICON
import hr.factory.base_module.models.location_raw_item.StringLocale
import io.realm.RealmList
import io.realm.RealmObject

/**
 * Created by domagoj on 23/11/17.
 */
open class BasicInformationItemRaw(var title: String, var descriptionEn: StringLocale?, var descriptionHr: StringLocale?, var metaEn: StringLocale?, var metaHr: StringLocale?, var imageUrl: Int, var contactListHr: RealmList<ContactRaw>, var contactListEn: RealmList<ContactRaw>) : RealmObject() {
    constructor() : this(EMPTY_STRING, StringLocale(), StringLocale(), StringLocale(), StringLocale(), STUB_IMAGE_ICON, RealmList(), RealmList())
    constructor(title: String, descriptionEn: StringLocale, descriptionHr: StringLocale) : this(title = title, descriptionEn = descriptionEn, descriptionHr = descriptionHr, contactListHr = RealmList<ContactRaw>(), contactListEn = RealmList<ContactRaw>(), imageUrl = STUB_IMAGE_ICON, metaEn = StringLocale(), metaHr = StringLocale())
    constructor(title: String, descriptionEn: StringLocale, descriptionHr: StringLocale, contactListHr: RealmList<ContactRaw>, contactListEn: RealmList<ContactRaw>) : this(title = title, descriptionEn = descriptionEn, descriptionHr = descriptionHr, imageUrl = STUB_IMAGE_ICON, contactListHr = RealmList<ContactRaw>(), contactListEn = RealmList<ContactRaw>(), metaEn = StringLocale(), metaHr = StringLocale())
    constructor(title: String, contactListHr: RealmList<ContactRaw>, contactListEn: RealmList<ContactRaw>) : this(title = title, descriptionEn = StringLocale(), descriptionHr = StringLocale(), imageUrl = STUB_IMAGE_ICON, contactListHr = contactListHr, contactListEn = contactListEn, metaEn = StringLocale(), metaHr = StringLocale())
    constructor(title: String, descriptionEn: StringLocale, descriptionHr: StringLocale, imageUrl: Int) : this(title = title, descriptionEn = descriptionEn, descriptionHr = descriptionHr, contactListHr = RealmList<ContactRaw>(), contactListEn = RealmList<ContactRaw>(), imageUrl = imageUrl, metaEn = StringLocale(), metaHr = StringLocale())
    constructor(title: String, descriptionEn: StringLocale, descriptionHr: StringLocale, metaEn: StringLocale, metaHr: StringLocale, imageUrl: Int) : this(title = title, descriptionEn = descriptionEn, descriptionHr = descriptionHr, contactListHr = RealmList<ContactRaw>(), metaEn = metaEn, metaHr = metaHr, contactListEn = RealmList<ContactRaw>(), imageUrl = imageUrl)
}