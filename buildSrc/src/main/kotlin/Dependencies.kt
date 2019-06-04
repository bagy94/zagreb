
object BuildTools{
    object Versions{
        const val gradle = "3.2.1"
        const val kotlin = "1.3.21"
    }
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin = "stdlib-jdk7"
}

object AndroidSDK{
    const val app = "com.android.application"
    const val applicationId = "hr.factory.zagreb_now_and_then"
    const val library = "com.android.library"
    const val feature = "com.android.feature"
    const val min = 21
    const val target = 28
    const val compile = 28
}

object Libraries{
    internal object Versions{
        const val kotlinCore = "1.0.1"
        const val appCompat = "1.0.2"
        const val navigation = "1.0.0"
        const val safeArgs = "2.1.0-alpha03"
        const val koin = "2.0.0-beta-4"
        const val constraintLayout = "1.1.2"
        const val rxJava = "2.2.8"
        const val rxJavaAndroid = "2.1.1"
        const val rxJavaBinding = "3.0.0-alpha2"
        const val rxKotlin = "2.3.0"
        const val materialComponents = "1.1.0-alpha06"
        const val coordinatorLayout = "1.0.0"
        const val recyclerView = "1.1.0-alpha05"
        //const val drawerLayout = "1.0.0"
        const val realm = "5.11.0"
        const val googleMaps = "16.1.0"
        const val glide = "4.9.0"


    }
    const val kotlinCore = "androidx.core:core-ktx:${Versions.kotlinCore}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    //Navigation
    const val navigationFragment = "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgs}"
    //Koin
    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    //ConstraintLayout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    //RxJava
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxJavaAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxJavaAndroid}"
    const val rxBinding = "com.jakewharton.rxbinding3:rxbinding:${Versions.rxJavaBinding}"
    const val rxBindingCore = "com.jakewharton.rxbinding3:rxbinding-core:${Versions.rxJavaBinding}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    //Material
    const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
    //Coordinator
    const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorLayout}"
    //DrawerLayout
    //const val drawerLayout = "androidx.drawerlayout:drawerlayout:${Versions.drawerLayout}"
    //RecyclerView
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    //Realm
    const val realm = "io.realm:realm-gradle-plugin:${Versions.realm}"
    //Google-maps
    const val googleMaps = "com.google.android.gms:play-services-maps:${Versions.googleMaps}"
    //Glide for images
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

}
object Test{
    internal object Versions{
        const val jUnit = "4.12"
    }
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val runner = "androidx.test:runner:1.1.1"
    const val instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val espresso = "androidx.test.espresso:espresso-core:3.1.1"
}

object Plugins{
    const val library = "com.android.library"
    const val kotlinAndroid = "android"
    const val kotlinExtensions = "android.extensions"
    const val kotlinKapt = "kapt"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
    const val realm = "realm-android"
}
object Compilers{
    internal object Versions{
        const val glide = "4.9.0"
    }
    //Glide kapt
    const val glide = "com.github.bumptech.glide:compiler:${Versions.glide}"
}




