object Versions {
    val work_version = "2.7.1"
    val core_ktx_version = "1.9.0"
    val kotlin_version = "1.9.0"
    val nav_version = "2.5.2"
    val appcompat_version = "1.5.0"
    val fragment_version = "1.5.2"
    val cardview_version = "1.0.0"
    val recyclerview_version = "1.2.1"
    val multidex_version = "2.0.1"
    val lifecycle_version = "2.5.1"
    val room_version = "2.4.3"
    val legacy_version = "1.0.0"
    val constraintlayout_version = "2.1.4"
    val material_version = "1.6.1"
    val activity_compose_version = "1.8.2"
    val compose_bom_version = "2024.02.01"
    val compose_version = "1.6.0"
    val compose_navigation_version = "2.4.0"
    val compose_material_version = "1.2.0"
    val compose_coil_version = "1.3.2"
    val retrofit2_version = "2.9.0"
    val okhttp3_version = "4.10.0"
    val converter_gson_version = "2.9.0"
    val logging_interceptor_version = "4.10.0"
    val flowLayout_version = "1.3.3"
    val gson_version = "2.9.1"
    val coroutines_version = "1.6.4"
    val hilt_android = "2.48.1"
    val hilt_view_model = "1.0.0-alpha03"
    val hilt_kapt = "2.48.1"
    val hilt_kapt_compiler = "1.0.0"
    val activityKtxVersion = "1.5.1"
    val fragmentKtxVersion = "1.5.2"
    val glideVersion = "4.12.0"
    val glideProcessorVersion = "4.13.2"
    val androidx_test_version = "1.4.0"
    val mockito_version = "3.3.3"
    val kotlinTest = "1.3.61"
    val androidx_espresso_idling_resource = "3.2.0"
    val mockk_version = "1.9.2"
    val androidx_test_ext = "1.1.3"
    val test_junit = "4.3.12"
    val espresso = "3.4.0"
    val mockitoInline = "2.11.0"
    val test_arch_core = "2.1.0"
    val mockitoKotlinVersion = "2.2.0"
    val flex_box_layout = "3.0.0"
    val hawk_version = "2.0.1"
    val viewpager2_version = "1.0.0"
    val sharedPreference = "1.0.6"
    val work_ktx_version = "2.7.0"
    val androidx_test_ktx_version = "1.2.0"
    val test_runner = "1.1.1"

    // testing
    val hamcrest_version = "1.3"
    val robolectric_version = "4.5.1"
    val mockito_dexmaker_version = "2.12.1"
    val truth_version = "1.1.2"
    val hilt_testing_version = "2.28-alpha"
}

object Kotlin {
    val kotlin_stdlib_jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx_version}"
    val work_ktx = "androidx.work:work-runtime-ktx:${Versions.work_ktx_version}"
    val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin_version}"
}

object Androidx {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview_version}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview_version}"
    val multidex = "androidx.multidex:multidex:${Versions.multidex_version}"
    val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}"
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy_version}"
    val lifecycle_compiler_kapt =
        "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"
    val ifecycle_reactivestreams =
        "androidx.lifecycle:lifecycle-reactivestreams:${Versions.lifecycle_version}"
    val lifecycle_common =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle_version}"
    val lifecycle_runtime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
    val lifecycle_livedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout_version}"
    val navigation_fragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    val room_compiler_kapt = "androidx.room:room-compiler:${Versions.room_version}"
    val lifecycle_viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"

    val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtxVersion}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
    val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2_version}"
    val flowLayout = "com.nex3z:flow-layout:${Versions.flowLayout_version}"
}

object Material {
    val material = "com.google.android.material:material:${Versions.material_version}"
}

object Compose {
    val activity_compose = "androidx.activity:activity-compose:${Versions.activity_compose_version}"
    val compose_bom = "androidx.compose:compose-bom:${Versions.compose_bom_version}"
    val compose_ui = "androidx.compose.ui:ui"
    val compose_navigation =
        "androidx.navigation:navigation-compose:${Versions.compose_navigation_version}"
    val compose_graphics = "androidx.compose.ui:ui-graphics"
    val compose_runtime = "androidx.compose.runtime:runtime"
    val compose_foundation = "androidx.compose.foundation:foundation"
    val compose_animation = "androidx.compose.animation:animation"
    val compose_material = "androidx.compose.material:material"
    val compose_material3 =
        "androidx.compose.material3:material3"
    val compose_tooling_preview = "androidx.compose.ui:ui-tooling-preview"
    val compose_ui_test_junit = "androidx.compose.ui:ui-test-junit4"
    val compose_ui_tooling = "androidx.compose.ui:ui-tooling"
    val compose_ui_test_manifest = "androidx.compose.ui:ui-test-manifest"
    val compose_coil =  "io.coil-kt:coil-compose:${Versions.compose_coil_version}"

}

object Retrofit {
    val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2_version}"
    val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3_version}"
    val converter_gson =
        "com.squareup.retrofit2:converter-gson:${Versions.converter_gson_version}"
    val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor_version}"
}

object Gson {
    val gson = "com.google.code.gson:gson:${Versions.gson_version}"
}

object Coroutines {
    val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_version}"
    val android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"
}


object Hilt {
    val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android}"

    //    val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_view_model}"
    val kapt_hilt_android = "com.google.dagger:hilt-android-compiler:${Versions.hilt_kapt}"
    val kapt_hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt_kapt_compiler}"
}


object TestLib {

    val junit = "junit:junit:${Versions.test_junit}"

    // AndroidX test
    val androidxTestCore = "androidx.test:core:${Versions.androidx_test_version}"
    val androidxTestCoreKtx = "androidx.test:core-ktx:${Versions.androidx_test_ktx_version}"
    val runner = "androidx.test:runner:${Versions.test_runner}"
    val testRules = "androidx.test:rules:${Versions.test_runner}"
    val testExt = "androidx.test.ext:junit-ktx:${Versions.androidx_test_ext}"

    // Architecture components testing
    val core_testing = "androidx.arch.core:core-testing:${Versions.test_arch_core}"
    val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.fragment_version}"
    val navigationTesting = "androidx.navigation:navigation-testing:${Versions.nav_version}"

    val mockito_core = "org.mockito:mockito-core:${Versions.mockito_version}"
    val mockito = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    val mockito_kotlin =
        "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"

    // Kotlin test
    val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlinTest}"

    val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val espresso_contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"

    val androidx_espresso_idling_resource =
        "androidx.test.espresso:espresso-idling-resource:${Versions.androidx_espresso_idling_resource}"

    val mockk = "io.mockk:mockk-android:${Versions.mockk_version}"
    val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines_version}"
}

object WorkManager {
    val workManager = "androidx.work:work-runtime-ktx:${Versions.work_version}"
}

object SharedPreference {
    val sharedPreference = "com.github.yehiahd:FastSave-Android:${Versions.sharedPreference}"
    val hawk = "com.orhanobut:hawk:${Versions.hawk_version}"
}

object Glide {
    val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    val glideProcess = "com.github.bumptech.glide:compiler:${Versions.glideProcessorVersion}"
}

object Lib {
    val flexBoxLayout = "com.google.android.flexbox:flexbox:${Versions.flex_box_layout}"
}
