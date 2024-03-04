// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}

buildscript {
    extra.apply {
    }
    extra.apply {
        set("minSdkVersion", AppConfig.minSdk)
        set("targetSdkVersion", AppConfig.targetSdk)
        set("kotlin_version", "1.9.0")
        set("nav_version", "2.5.2")
        set("build_tools", "8.1.0")
        set("hilt_plugin", "2.48.1")
        set("junit5", "1.6.1.0")
    }

    dependencies {
        val build_tools = rootProject.extra["build_tools"]
        val nav_version = rootProject.extra["nav_version"]
        val kotlin_version = rootProject.extra["kotlin_version"]
        val hilt_plugin = rootProject.extra["hilt_plugin"]
        val junit5 = rootProject.extra["junit5"]

        classpath("com.android.tools.build:gradle:$build_tools")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hilt_plugin")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:$junit5")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}