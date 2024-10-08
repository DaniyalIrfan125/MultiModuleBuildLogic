import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.di.multimodule.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {

    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)

}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "MultiModuleBuildLogic.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "MultiModuleBuildLogic.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidHilt") {
            id = "MultiModuleBuildLogic.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidLint") {
            id = "MultiModuleBuildLogic.android.lint"
            implementationClass = "AndroidLintConventionPlugin"
        }

        register("androidRoom") {
            id = "MultiModuleBuildLogic.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("androidFirebase") {
            id = "MultiModuleBuildLogic.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }

    }
}