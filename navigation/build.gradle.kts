plugins{
    id(Plugins.library)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExtensions)
    kotlin(Plugins.kotlinKapt)
}
apply(plugin = Plugins.safeArgs)
android {
    compileSdkVersion(AndroidSDK.compile)
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":base_module"))
}
