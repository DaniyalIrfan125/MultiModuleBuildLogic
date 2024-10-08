plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.android.hilt)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.custom.android.room)
}

android {
    namespace = "com.di.moduleb"

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

    // Enable NDK support
    externalNativeBuild {
        cmake {
            version = "3.22.1" // Specify your desired CMake version
            path = file("src/main/cpp/CMakeLists.txt") // Path to CMakeLists.txt
        }
    }

    ndkVersion = "27.1.12297006"


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