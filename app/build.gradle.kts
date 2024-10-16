plugins {
    alias(libs.plugins.ksp)
    alias(libs.plugins.custom.android.application)
 //   alias(libs.plugins.android.application.firebase)
    alias(libs.plugins.custom.android.hilt)
}

android {
    namespace = "com.uae.myvaultspay"
    defaultConfig {
        applicationId = "com.uae.myvaultspay"
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
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


    implementation(projects.usermodule)
    implementation(projects.merchantmodule)
}