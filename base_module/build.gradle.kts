plugins {
    id(Plugins.library)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExtensions)
    kotlin(Plugins.kotlinKapt)
}
apply(plugin = Plugins.realm)

android {
    compileSdkVersion(AndroidSDK.compile)
    defaultConfig {
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = Test.instrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.runner)
    androidTestImplementation(Test.espresso)
    api(Libraries.appCompat)
    api(Libraries.kotlinCore)
    api(kotlin(BuildTools.kotlin, BuildTools.Versions.kotlin))

    //Navigation
    api(Libraries.navigationFragment)
    api(Libraries.navigation)
    //Koin
    api(Libraries.koinCore)
    api(Libraries.koinScope)
    //RxJava
    api(Libraries.rxJava)
    api(Libraries.rxJavaAndroid)
    api(Libraries.rxBinding)
    api(Libraries.rxKotlin)
    //Material
    api(Libraries.materialComponents)
    api(Libraries.coordinatorLayout)
    //ConstraintLayout
    api(Libraries.constraintLayout)
    //Maps
    api(Libraries.googleMaps)
    //Glide
    api(Libraries.glide)
    kapt(Compilers.glide)
}
repositories {
    mavenCentral()
    google()
}
