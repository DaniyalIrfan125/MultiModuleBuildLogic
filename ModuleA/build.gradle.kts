plugins {
//    alias(libs.plugins.android.library)
//    alias(libs.plugins.jetbrains.kotlin.android)

//    id("MultiModuleBuildLogic.android.library")
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.android.hilt)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.di.modulea"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
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

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}