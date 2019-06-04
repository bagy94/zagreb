plugins{
    id(AndroidSDK.feature)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExtensions)
    kotlin(Plugins.kotlinKapt)
}
android {
    compileSdkVersion(AndroidSDK.compile)

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