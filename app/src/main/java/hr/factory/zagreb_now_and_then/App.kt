package hr.factory.zagreb_now_and_then

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import hr.factory.app_location_gallery.locationGalleryModule
import hr.factory.app_send_postcard.sendPostcardModule
import hr.factory.base_module.models.copyBundledRealmFile
import hr.factory.base_module.utils.setLocale
import hr.factory.home_location.homeLocationListModule
import hr.factory.locations_single.singleLocationModule
import hr.factory.splash.di.splashModule
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initRealmDatabase()
        startKoin {
            androidContext(this@App)
            modules(
                applicationModule,
                splashModule,
                homeLocationListModule,
                singleLocationModule,
                locationGalleryModule,
                sendPostcardModule)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        setLocale(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(setLocale(base))
    }


    private fun initRealmDatabase() {
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .name("pozdrav_zagrebu")
                .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        copyBundledRealmFile()
    }
}