// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath (BuildTools.gradlePlugin)
        classpath (kotlin("gradle-plugin",BuildTools.Versions.kotlin))
        classpath (Libraries.realm)
        classpath (Libraries.safeArgs)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven (url = "https://jitpack.io")
    }
}
tasks.register("clean").configure{
    delete("build")
}
