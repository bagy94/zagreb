plugins {
    id("com.android.application")
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExtensions)
    kotlin(Plugins.kotlinKapt)
}
apply(plugin = Plugins.realm)
android {
    compileSdkVersion(AndroidSDK.compile)
    defaultConfig {
        applicationId = AndroidSDK.applicationId
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
    implementation(project(":base_module"))
    implementation(project(":app_splash"))
    implementation(project(":navigation"))
    implementation(project(":app_home"))
    implementation(project(":app_single_location"))
    implementation(project(":app_location_gallery"))
    implementation(project(":app_send_postcard"))
}
