plugins{
    id(AndroidSDK.feature)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExtensions)
    kotlin(Plugins.kotlinKapt)
}
apply(plugin = Plugins.safeArgs)
android {
    compileSdkVersion(AndroidSDK.compile)
    defaultConfig {
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)
    }

}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":base_module"))
    implementation(project(":app_navigation"))
    implementation(Libraries.constraintLayout)
    implementation(Libraries.recyclerView)
    implementation(Libraries.glide)
    kapt(Compilers.glide)
}
