plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = (AppConfig.nameSpec)
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        compileSdk = AppConfig.compileSdk
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    //kotlin
    implementation(Kotlin.kotlin_stdlib_jdk)
    implementation(Kotlin.kotlin_stdlib)
    implementation(Kotlin.core_ktx)
    implementation(Kotlin.kotlin_reflect)

    //Androidx
    implementation(Androidx.appcompat)
    implementation(Androidx.fragment)
    implementation(Androidx.cardview)
    implementation(Androidx.recyclerview)
    implementation(Androidx.multidex)
    implementation(Androidx.legacy)
    kapt(Androidx.appcompat)
    implementation(Androidx.ifecycle_reactivestreams)
    implementation(Androidx.lifecycle_common)
    implementation(Androidx.lifecycle_runtime)
    implementation(Androidx.lifecycle_livedata)
    implementation(Androidx.constraintlayout)
    implementation(Androidx.navigation_fragment)
    implementation(Androidx.navigation_ui)
    implementation(Androidx.lifecycle_viewmodel)
    implementation(WorkManager.workManager)

    //Retrofit
    implementation(Retrofit.retrofit2)
    implementation(Retrofit.okhttp3)
    implementation(Retrofit.converter_gson)
    implementation(Retrofit.logging_interceptor)

    //Gson
    implementation(Gson.gson)

    //Coroutines
    implementation(Coroutines.core)
    implementation(Coroutines.android)

    //Hilt
    implementation(Hilt.hilt_android)
    kapt(Hilt.kapt_hilt_android)
    kapt(Hilt.kapt_hilt_compiler)
}